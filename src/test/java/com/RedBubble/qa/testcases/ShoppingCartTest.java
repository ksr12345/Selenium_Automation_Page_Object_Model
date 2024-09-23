package com.RedBubble.qa.testcases;

import com.RedBubble.qa.base.TestBase;
import com.RedBubble.qa.pages.Home_Page;
import com.RedBubble.qa.pages.Login_Page;
import com.RedBubble.qa.pages.ShoppingCart_Page;
import com.RedBubble.qa.pages.TShirts_Page;
import io.qameta.allure.*;
import listeners.CustomListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ShoppingCartTest extends TestBase {
    Login_Page loginPage;
    Home_Page homePage;
    TShirts_Page tShirtsPage;
    ShoppingCart_Page shoppingCartPage;

    public ShoppingCartTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new Login_Page();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        tShirtsPage = homePage.Search();
        shoppingCartPage = tShirtsPage.chooseItem();
    }

    @Test(priority = 1)
    @Description("Selecting and adding to cart")
    @Epic("EP001")
    @Feature("Feature1 : select and add to cart")
    @Story("Story : Selecting an item and adding to cart ")
    @Severity(SeverityLevel.CRITICAL)
    public void enter_address() throws InterruptedException{
        shoppingCartPage.enter_details();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
