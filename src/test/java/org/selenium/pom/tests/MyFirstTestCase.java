package org.selenium.pom.tests;



import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {

//            BillingAddress billingAddress=new BillingAddress().
//                 setFirstName("James").
//                 setLastName("Jcobs").
//                 setCompanyName("D-Company").
//                 setBillingAddress1("8 Lavelle Street  Oxford Town").
//                 setBillingAddress2("near University,Town Manchester").
//                 setBillingCity("London").
//                 setBillingPostCode("94188").
//                 setPhone("9876543210").
//                 setEmail("demouser100@gmail.com").
//                 setComments("to be nice");

//        BillingAddress billingAddress=new BillingAddress("James","Jcobs","D-Company","8 Lavelle Street  Oxford Town","near University,Town Manchester","London","94188","9876543210","demouser100@gmail.com","to be nice");


        String search="Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product=new Product(1215);
        StorePage storePage=new HomePage(driver).
                    load().
                    navigateToStoreUsingMenu().
                     search(search);
            Assert.assertEquals(storePage.getTitle(),"Search results: “"+search+"”");

            storePage.clickAddToCartBtn(product.getName());
            CartPage cartPage=storePage.clickOnViewCart();
            Assert.assertEquals(cartPage.getProductName(),product.getName());

            CheckOutPage checkOut=cartPage.checkOut().
                    setBillingAddress(billingAddress).
                    selectDirectBankTransfer().
                    clickOnPlaceOrder();
            Assert.assertEquals(checkOut.getNotice(),"Thank you. Your order has been received.");

            driver.close();
    }

        @Test
        public void logInAndCheckoutUsingDirectBankTransfer() throws IOException {

//        BillingAddress billingAddress=new BillingAddress("James","Jcobs","D-Company","8 Lavelle Street  Oxford Town","near University,Town Manchester","London","94188","9876543210","demouser100@gmail.com","to be nice");

            String search="blue";
            BillingAddress billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
            Product product=new Product(1215);
            User user=new User("demouser100@gmail.com","demopass");
                StorePage storePage=new HomePage(driver).
                        load().
                        navigateToStoreUsingMenu().
                        search(search);
                Assert.assertEquals(storePage.getTitle(),"Search results: “"+search+"”");

                storePage.clickAddToCartBtn(product.getName());
                CartPage cartPage=storePage.clickOnViewCart();
                Assert.assertEquals(cartPage.getProductName(),product.getName());

                CheckOutPage checkOutPage =cartPage.checkOut();
                checkOutPage.clickOnLoginLink();
                checkOutPage.
                        login(user);

                checkOutPage.setBillingAddress(billingAddress).
                        selectDirectBankTransfer().
                        clickOnPlaceOrder();

                Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
               driver.close();
    }
}
