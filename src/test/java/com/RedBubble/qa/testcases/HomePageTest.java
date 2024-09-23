package com.RedBubble.qa.testcases;

import com.RedBubble.qa.base.TestBase;
import com.RedBubble.qa.pages.*;
import io.qameta.allure.*;
import listeners.CustomListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase {
    Login_Page loginPage;
    Home_Page homePage;
    TShirts_Page tShirtsPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new Login_Page();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        tShirtsPage = new TShirts_Page();
    }

    @Test(priority = 1)
    @Description("User search")
    @Epic("EP001")
    @Feature("Feature1 : Search")
    @Story("Story : Search T-Shirts")
    @Severity(SeverityLevel.CRITICAL)
    public void searchItem() throws InterruptedException{
        tShirtsPage = homePage.Search();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
