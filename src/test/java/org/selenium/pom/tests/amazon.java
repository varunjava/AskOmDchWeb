package org.selenium.pom.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

    @Test
    public void mobiles() {
    }

    public static void main(String[] args) {

        mobile("electronics", "Laptop", "Dell", "Dell 14 Laptop, 12th Gen Intel Core i3-1215U Processor/8GB/512GB SSD/Intel");
    }

    public static void mobile(String product, String device, String brandName, String model)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        WebElement electronicsButton=driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_"+product+"']"));
        electronicsButton.click();

//        String xpath = "//li[@id='sobe_d_b_6_1']//img[@alt='%s']";
//        String xpath1 = String.format(xpath, "Dell");

//        String xpath1 = "//li[@id='sobe_d_b_6_1']//img[@alt='"+product+"']";

//        WebElement laptopsButton=driver.findElement(By.xpath(xpath1));
//        laptopsButton.click();

        WebElement firstElement=driver.findElement(By.xpath("//div[@class='bxc-grid__column  bxc-grid__column--3-of-12   bxc-grid__column--light']"));
        firstElement.click();

        WebElement brandNameIcon=driver.findElement(By.xpath("//li[@id='sobe_d_b_6_1']/../..//img[@alt='"+brandName+"']"));
        brandNameIcon.click();

        String winId=driver.getWindowHandle().toString();

        try {
            WebElement laptopModel=driver.findElement(By.xpath("//span[contains(text(),'"+model+"')]"));
            laptopModel.click();
        }
        catch (Exception e)
        {
            driver.switchTo().window(winId);
        }

        WebElement buyNowButton=driver.findElement(By.xpath("//span[@id='submit.buy-now']"));
        buyNowButton.click();

    }
}
