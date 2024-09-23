package com.RedBubble.qa.pages;

import com.RedBubble.qa.base.TestBase;
import listeners.CustomListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


public class Login_Page extends TestBase {
    public static Logger logger =Logger.getLogger(Login_Page.class);

    //PageFactory - OR:
    @FindBy(name="usernameOrEmail")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath= "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@class='account-nav-link']")
    WebElement signupBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[1]/div/div/div/header/div[1]/a[2]")
    WebElement LoginBtn;


    public Login_Page(){
        PageFactory.initElements(driver, this);
        logger.info("login page element is intialized");
    }

    public String validateLoginPageTitle() throws InterruptedException {
        Thread.sleep(2000);
        LoginBtn.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }


    public Home_Page login(String un, String pswd) throws InterruptedException {
        Thread.sleep(2000);
        LoginBtn.click();
        Thread.sleep(2000);
        username.sendKeys(un);
        password.sendKeys(pswd);
        Thread.sleep(2000);
        loginBtn.click();

        return new Home_Page();
    }
}
