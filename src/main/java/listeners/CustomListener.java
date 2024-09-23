package listeners;

import com.RedBubble.qa.base.TestBase;
import com.RedBubble.qa.pages.Login_Page;
import com.RedBubble.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends TestBase implements ITestListener {

    public static Logger logger =Logger.getLogger(CustomListener.class);
    TestUtil util;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Testcase started"+ result.getName());
        extentReports.attachReporter(extentSparkReporter);
        test = extentReports.createTest(result.getName());
        test.log(Status.INFO, "The test case is started"+ result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Testcase skipped"+ result.getName());
        test = extentReports.createTest(result.getName());
        test.log(Status.SKIP, "The test case is started"+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Testcase success"+ result.getName());
        test = extentReports.createTest(result.getName());
        test.log(Status.PASS, "The test case is started"+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Testcase failed"+ result.getName());
        test = extentReports.createTest(result.getName());
        util=new TestUtil();
        util.takescreenshotFaliure(driver);
        test.log(Status.FAIL, "The test case is started"+ result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Flushed the Extent Report");
        extentReports.flush();
    }

}

