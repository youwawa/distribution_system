/** 
 * (C) Copyright YOUWAWA Corporation, All Rights Reserved.
 */
package alltest;

import com.yww.distribution.generate.controller.TestGetCodeController;
import com.yww.distribution.schedule.TestAutoCreateCodeController;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * <strong>test suite。</strong>
 *
 * @author yw
 */
public class AllTest {

    public static Test suite() {

        TestSuite suite = new TestSuite(AllTest.class.getName());

        suite.addTest(new JUnit4TestAdapter(TestGetCodeController.class));
        suite.addTest(new JUnit4TestAdapter(TestAutoCreateCodeController.class));
        return suite;
    }
}
