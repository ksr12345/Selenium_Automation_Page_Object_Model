package com.RedBubble.qa.pages;

import com.RedBubble.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirts_Page extends TestBase {
    public static Logger logger =Logger.getLogger(TShirts_Page.class);

    @FindBy(xpath = "(//img[@alt='Item preview, Stay Positive designed and sold by Steven Rhodes.'])[1]")
    WebElement selectProduct;

    @FindBy(xpath = "//input[@value='extra_large']")
    WebElement selectSize;

    @FindBy(xpath = "(//button[@type=\"submit\"])[2]")
    WebElement AddtoCartBtn;

    @FindBy(xpath = "//a[@class='styles_button__12ad25d8 styles_primary__12ad25d8 styles_fluid__12ad25d8 styles_strong__12ad25d8 styles_large__12ad25d8']")
    WebElement ViewCartBtn;

    public TShirts_Page(){
        PageFactory.initElements(driver, this);
        logger.info("TShirt element is initiated");
    }

    public ShoppingCart_Page chooseItem() throws InterruptedException{
        js.executeScript("window.scrollBy(0,300)");
        selectProduct.click();
        js.executeScript("window.scrollBy(0,600)");
        selectSize.click();
        AddtoCartBtn.click();
        ViewCartBtn.click();


        return new ShoppingCart_Page();
    }
}
