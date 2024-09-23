package com.RedBubble.qa.testcases;

import com.RedBubble.qa.base.TestBase;
import com.RedBubble.qa.pages.Home_Page;
import com.RedBubble.qa.pages.Login_Page;
import io.qameta.allure.*;
import listeners.CustomListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase {

    Login_Page loginPage;
    Home_Page homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new Login_Page();
    }

    @Test(priority = 1)
    @Description("User login the application title")
    @Epic("EP001")
    @Feature("Feature1 : Login title")
    @Story("Story : login page title ")
    @Severity(SeverityLevel.CRITICAL)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Log In | Redbubble");
    }


    @Test(priority = 2)
    @Description("User login the application")
    @Epic("EP001")
    @Feature("Feature1 : Login")
    @Story("Story : login the account with emailid and password ")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
