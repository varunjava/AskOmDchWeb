package org.selenium.pom.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;


public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink=By.cssSelector(".showlogin");
    private final By userNameFld=By.cssSelector("#username");
    private final By passwordFld=By.cssSelector("#password");
    private final By loginBtn=By.cssSelector("button[value='Login']");
    private final By firstNameFld=By.cssSelector("#billing_first_name");
    private final By lastNameFld=By.cssSelector("#billing_last_name");
    private final By companyNameFld=By.cssSelector("#billing_company");
    private final By countryDropDown=By.id("billing_country");
    private final By billingAddress1Fld=By.cssSelector("#billing_address_1");
    private final By  billingAddress2Fld=By.cssSelector("#billing_address_2");
    private final By billingCityFld=By.cssSelector("#billing_city");
    private final By stateDropDown=By.id("billing_state");
    private final By billingPostcodeFld=By.cssSelector("#billing_postcode");
    private final By billingPhoneFld= By.cssSelector("#billing_phone");
    private final By billingEmailFld=By.cssSelector("#billing_email");
    private final By orderCommentsFld=By.cssSelector("#order_comments");
    private final By directBankTransferRadioBtn=By.id("payment_method_bacs");
    private final By placeOrderBtn=By.cssSelector("#place_order");
    private final By overlay=By.cssSelector(".blockUI.blockOverlay");
    private final By successNotice=By.xpath("//*[text()='Thank you. Your order has been received.']");

    public CheckOutPage clickOnLoginLink(){
        driver.findElement(loginLink).click();
        return this;
    }

    public CheckOutPage enterUserName(String userName){
        driver.findElement(userNameFld).sendKeys(userName);
        return this;
    }

    public CheckOutPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckOutPage clickOnLogoutBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }
    public CheckOutPage login(String userName,String password){
        return  enterUserName(userName).
        enterPassword(password).
        clickOnLogoutBtn();
    }

    public void login(User user) {
    }

    public CheckOutPage enterFirstName(String firstName){
      WebElement e= getElement(firstNameFld);
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }
    public CheckOutPage enterCompanyName(String companyName){
        driver.findElement(companyNameFld).clear();
        driver.findElement(companyNameFld).sendKeys(companyName);
        return this;
    }

    public CheckOutPage selectCounty(String countryName){
        Select select=new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);
        return this;
    }
    public CheckOutPage enterBillingAddress1(String billingAddress1){
        driver.findElement(billingAddress1Fld).clear();
        driver.findElement(billingAddress1Fld).sendKeys(billingAddress1);
        return this;
    }

    public CheckOutPage enterBillingAddress2(String billingAddress2){
        driver.findElement(billingAddress2Fld).clear();
        driver.findElement(billingAddress2Fld).sendKeys(billingAddress2);
        return this;
    }

    public CheckOutPage enterBillingCity(String billingCity){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(billingCity);
        return this;
    }

    public CheckOutPage selectState(String stateName){
        Select select=new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);
        return this;
    }

    public CheckOutPage enterBillingPostcode(String billingPostcode){
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostcodeFld));
        e.clear();
        e.sendKeys(billingPostcode);
        return this;
    }

    public CheckOutPage enterBillingPhone(String billingPhone){
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(billingPhoneFld));
        e.clear();
        e.sendKeys(billingPhone);
        return this;
    }

    public CheckOutPage enterBillingEmail(String billingEmail){
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckOutPage enterOrderComments(String orderComments){
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(orderCommentsFld));
        e.clear();
        e.sendKeys(orderComments);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
               return    enterFirstName(billingAddress.getFirstName()).
                         enterLastName(billingAddress.getLastName()).
                         enterCompanyName(billingAddress.getCompanyName()).
                         selectCounty(billingAddress.getCountryName()).
                         enterBillingAddress1(billingAddress.getBillingAddress1()).
                         enterBillingAddress2(billingAddress.getBillingAddress2()).
                         enterBillingCity(billingAddress.getBillingCity()).
                         selectState(billingAddress.getStateName()).
                         enterBillingPostcode(billingAddress.getBillingPostCode()).
                         enterBillingPhone(billingAddress.getPhone()).
                         enterBillingEmail(billingAddress.getEmail()).
                         enterOrderComments(billingAddress.getComments());
    }

    public CheckOutPage selectDirectBankTransfer(){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if (!e.isSelected()){
            e.click();
        }
        return this;
    }

    public CheckOutPage clickOnPlaceOrder(){
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
       return   wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }


}
