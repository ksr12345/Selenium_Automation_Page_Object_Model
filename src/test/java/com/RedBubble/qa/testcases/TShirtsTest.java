package com.RedBubble.qa.testcases;

import com.RedBubble.qa.base.TestBase;
import com.RedBubble.qa.pages.Home_Page;
import com.RedBubble.qa.pages.Login_Page;
import com.RedBubble.qa.pages.TShirts_Page;
import com.RedBubble.qa.pages.ShoppingCart_Page;
import io.qameta.allure.*;
import listeners.CustomListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TShirtsTest extends TestBase{
    Login_Page loginPage;
    Home_Page homePage;
    TShirts_Page tShirtsPage;
    ShoppingCart_Page shoppingCartPage;

    public TShirtsTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new Login_Page();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        tShirtsPage = homePage.Search();
        shoppingCartPage = new ShoppingCart_Page();
    }

    @Test(priority = 1)
    @Description("Selecting and adding to cart")
    @Epic("EP001")
    @Feature("Feature1 : select and add to cart")
    @Story("Story : Selecting an item and adding to cart ")
    @Severity(SeverityLevel.CRITICAL)
    public void bookItem() throws InterruptedException{
        shoppingCartPage = tShirtsPage.chooseItem();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
