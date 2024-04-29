package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

//    private final By productName=By.cssSelector("td[class='product-name'] a");
//    private final By checkOutBtn=By.cssSelector(".checkout-button");

    @FindBy(css = "td[class='product-name'] a")  private WebElement productName;
    @FindBy(css = ".checkout-button") @CacheLookup private WebElement checkOutBtn;
    public String getProductName(){

        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public CheckOutPage checkOut(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
        return new CheckOutPage(driver);
    }
}
