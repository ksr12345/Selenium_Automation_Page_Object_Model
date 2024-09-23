package com.RedBubble.qa.pages;

import com.RedBubble.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page extends TestBase {
    public static Logger logger =Logger.getLogger(TShirts_Page.class);

    @FindBy(xpath = "(//span[@class=\"styles_children__12ad25d8\"])[5]")
    WebElement Checkout_btn;

    @FindBy(xpath = "//*[@id=\"PaymentOptions\"]/div[2]/div/div[1]/div/div[1]/span/a")
    WebElement Pay_by_btn;

    @FindBy(name = "contactDetailsEmail")
    WebElement Email_text;

    @FindBy(name = "name")
    WebElement Full_name;

    @FindBy(name = "addressLine1")
    WebElement Address;

    @FindBy(name = "locality")
    WebElement City;

    @FindBy(name = "postalCode")
    WebElement Pin;

    @FindBy(name = "administrativeArea")
    WebElement State;

    @FindBy(name = "phone")
    WebElement Moblie_no;

    @FindBy(xpath = "//*[@id=\"DeliveryAddress\"]/div[2]/div/div[1]/div/form/span/button")
    WebElement Continue_address;

    public ShoppingCart_Page(){
        PageFactory.initElements(driver, this);
        logger.info("Shopping Cart element is initiated");
    }

    public void enter_details() throws InterruptedException{
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        Checkout_btn.click();
        js.executeScript("window.scrollBy(0,500)");
        Pay_by_btn.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,200)");
        Email_text.sendKeys(prop.getProperty("email"));
        Full_name.sendKeys(prop.getProperty("Name"));
        Address.sendKeys("Address");
        City.sendKeys("City");
        Pin.sendKeys("Pin");
        State.sendKeys("State");
        Moblie_no.sendKeys("Phone");
        Continue_address.click();
    }

}
