/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package com.yww.distribution.generate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yww.distribution.dao.CodeOrderformMapper;
import com.yww.distribution.dao.CodePoolMapper;
import com.yww.distribution.entity.CodeOrderform;
import com.yww.distribution.generate.service.ICodePoolService;

/**
 * <strong>自动生成串码，取串码方法等服务类。</strong>
 *
 * @author ansh
 */
@Service
public class CodePoolServiceImpl implements ICodePoolService {

    @Resource
    private CodePoolMapper codePoolDao;
    @Resource
    private CodeOrderformMapper codeOrderformDao;

    /**
     * 获取配置文件中的codePool串码表设置的同时存放串码最大数量
     */
    @Value("${code-config.codePoolMaxSize}")
    private int codePoolMaxSize;

    @Override
    public String getCode(String externalId, Date endtime, int amount) {

        String code = codePoolDao.selectFirstCode();

        codePoolDao.deleteByCode(code);

        CodeOrderform bean = new CodeOrderform();
        bean.setCode(code);
        bean.setEndtime(endtime);
        bean.setExternalId(externalId);
        bean.setAmount(amount);
        bean.setState("1");

        codeOrderformDao.insert(bean);
        return code;
    }

    @Override
    public void autoCreateCodeInsertTypeBatch() {

        int generateCodeTotalCount = codePoolDao.getCodeCount();
        Set<String> allUnusedAndUsingCodeSet = getAllUnusedAndUsingCodeFromDB();
        generateCodeToCodePoolInsertTypeBatch(generateCodeTotalCount, allUnusedAndUsingCodeSet);
    }

    @Override
    public void autoCreateCodeInsertTypeSingle() {

        int generateCodeTotalCount = codePoolDao.getCodeCount();
        Set<String> allUnusedAndUsingCodeSet = getAllUnusedAndUsingCodeFromDB();
        generateCodeToCodePoolInsertTypeSingle(generateCodeTotalCount, allUnusedAndUsingCodeSet);
    }

    /**
     * <strong>生成指定数量的随机串码</strong>
     * <p>
     * 根据code_pool表中当前数量 和 配置文件中设置的 code_pool最大值 重新生成若干个不重复的随机码
     * 使code_pool表中数量达到设置的最大值
     * </p>
     *
     * @param codePoolTotalCount
     *            codePool随机码表的当前数量
     * @param allUnusedAndUsingCodeSet
     *            所有未使用和使用中的码，即新生成的码应该不和这些码重复
     * @param insertType
     *            插入数据库方式
     *            batchInsert :统一批量插入数据库，先将所有code放到list中，在统一插入数据库
     *            singleInsert :单一插入，每生成一个code，插入数据库
     * @author ansh
     */
    private void generateCodeToCodePoolInsertTypeBatch(int codePoolTotalCount, Set<String> allUnusedAndUsingCodeSet) {

        int count = codePoolMaxSize - codePoolTotalCount;
        // 如果insertType类型为batchInsert则批量插入sql文
        List<String> codeList = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            String code = getNotRepeatCodeByUnusedAndUsingCode(allUnusedAndUsingCodeSet);
            codeList.add(code);
        }
        // 若codelist长度大于0 则批量生成串码
        if (codeList.size() > 0) {
            codePoolDao.insertCodeByList(codeList);
        }

    }

    /**
     * <strong>生成指定数量的随机串码</strong>
     * <p>
     * 根据code_pool表中当前数量 和 配置文件中设置的 code_pool最大值 重新生成若干个不重复的随机码
     * 使code_pool表中数量达到设置的最大值
     * </p>
     *
     * @param codePoolTotalCount
     *            codePool随机码表的当前数量
     * @param allUnusedAndUsingCodeSet
     *            所有未使用和使用中的码，即新生成的码应该不和这些码重复
     * @param insertType
     *            插入数据库方式
     *            singleInsert :单一插入，每生成一个code，插入数据库
     * @author ansh
     */
    private void generateCodeToCodePoolInsertTypeSingle(int codePoolTotalCount, Set<String> allUnusedAndUsingCodeSet) {

        int count = codePoolMaxSize - codePoolTotalCount;
        // 每循环一次插入一次
        for (int i = 0; i < count; i++) {
            String code = getNotRepeatCodeByUnusedAndUsingCode(allUnusedAndUsingCodeSet);
            codePoolDao.insertCode(code);
        }

    }

    /**
     * <strong>获取一个十位随机串码。</strong>
     * <p>
     * 随机一个long类型随机数 取余9999999999 后得到的数 为小于 9999999999的随机数
     * 因long类型包含负数，需要将负数转为正数
     * 将生成的随机数转换成字符串，并预先定义一个十位0的字符串，
     * 生成的随机数的位数可能不足十位，替换一定位数的0到随机数前方
     * </p>
     *
     * @return
     * @author ansh
     */
    private String getRandomCode() {

        Random random = new Random();
        long randomNumber = random.nextLong() % 9999999999l;
        if (randomNumber < 0) {
            randomNumber = randomNumber * -1;
        }
        String randomString = "" + randomNumber;
        String zeroString = "0000000000";
        randomString = zeroString.substring(0, 10 - randomString.length()) + randomString;
        return randomString;
    }

    /**
     * 根据集合中所有的随机数，获取一个新的随机数，放到set集合中，
     * 如果集合长度加一，则新生成的随机数是不重复的，
     * 如果长度不加一，则这个随机数是重复的，再次获取一个新的随机数。
     * 
     * @param allUnusedAndUsingCodeSet
     * @return
     */
    /**
     * <strong>获取一个不重复的随机数。</strong>
     * <p>
     * 根据集合中所有的随机数，获取一个新的随机数，放到set集合中，
     * 如果集合长度加一，则新生成的随机数是不重复的，
     * 如果长度不加一，则这个随机数是重复的，再次获取一个新的随机数。
     * </p>
     *
     * @param allUnusedAndUsingCodeSet
     * @return
     * @author ansh
     */
    private String getNotRepeatCodeByUnusedAndUsingCode(Set<String> allUnusedAndUsingCodeSet) {

        int beforeSize = allUnusedAndUsingCodeSet.size();
        String code = "";
        do {
            code = getRandomCode();
            allUnusedAndUsingCodeSet.add(code);
        } while (allUnusedAndUsingCodeSet.size() == beforeSize);
        return code;
    }

    /**
     * <strong>从数据库中取出所有不能重复的串码（已经生成的串码中未使用的和已发出未核销的）。</strong>
     * <p>
     * 从数据库中取出所有未使用的串码和使用中未核销的串码
     * 用于对比之后生成的串码不与之重复
     * </p>
     *
     * @return
     * @author ansh
     */
    private Set<String> getAllUnusedAndUsingCodeFromDB() {

        Set<String> unusedcodeSet = codePoolDao.selectAll();
        Set<String> usingCodeSet = codeOrderformDao.selectAllUsing();
        unusedcodeSet.addAll(usingCodeSet);
        return unusedcodeSet;
    }

}
