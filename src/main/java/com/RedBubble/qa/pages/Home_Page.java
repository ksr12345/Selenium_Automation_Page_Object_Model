package com.RedBubble.qa.pages;

import com.RedBubble.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends TestBase {
    public static Logger logger =Logger.getLogger(Home_Page.class);

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/nav/ul/li[2]/a")
    WebElement Clothing_Btn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/nav/ul/li[3]/a")
    WebElement Stickers_Btn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/nav/ul/li[4]/a")
    WebElement PhoneCase_Btn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[1]/div/div/div/header/div[3]/div[2]/div/div/a")
    WebElement add_to_cart_btn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[2]/div/div/div/div[1]/div/a[3]")
    WebElement Following_section;

    @FindBy(name = "query")
    WebElement search_bar;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement search;

    public Home_Page(){
        PageFactory.initElements(driver, this);
        logger.info("Home Page element is initiated");
    }

    public TShirts_Page Search() throws InterruptedException{
        Thread.sleep(2000);
        search_bar.sendKeys("T-Shirts");
        Thread.sleep(2000);
        search.click();

        return new TShirts_Page();
    }


}
