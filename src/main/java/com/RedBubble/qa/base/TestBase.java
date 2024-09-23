package com.RedBubble.qa.base;

import com.RedBubble.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static JavascriptExecutor js;
    public static Logger logger;
    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("report.html");
    public TestBase() {
        try {
            extentSparkReporter.config().setReportName("Automation Test Report");
            extentSparkReporter.config().setDocumentTitle("Reports");
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentReports.setSystemInfo("operating System", "Windows 11");
            extentReports.setSystemInfo("Tester", "Kaustubh");
            extentReports.setSystemInfo("Browser", "Chrome");

            prop = new Properties();
            PropertyConfigurator.configure("C:\\Users\\kaust\\IdeaProjects\\FreeCRMTest\\src\\main\\java\\com\\RedBubble\\qa\\config\\log4j.properties");
            FileInputStream ip= new FileInputStream("C:/Users/kaust/IdeaProjects/FreeCRMTest/src/main/java/com/RedBubble/qa/config/config.properties");
            prop.load(ip);
            js = (JavascriptExecutor) driver;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browsername.equals("FF")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
