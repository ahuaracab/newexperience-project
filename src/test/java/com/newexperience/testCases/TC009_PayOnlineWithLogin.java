package com.newexperience.testCases;

import com.newexperience.pageObjects.AccountPage;
import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.OrderPage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC009_PayOnlineWithLogin extends BaseClass{
    @Test
    public void payOnlineWithLogin() throws InterruptedException, IOException {

        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkSignin();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))){
            logger.info("test failed");
            captureScreen(driver,"payOnlineWithLogin");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(5000);
        sip.setTxtEmail("ahuaracab333@mailinator.com");
        sip.setTxtPasswd("123456789");
        sip.clickBtnSubmitLogin();

        Thread.sleep(5000);

        AccountPage ap = new AccountPage(driver);
        Thread.sleep(5000);

        if (!(ap.getLnkAccountName().equals("Angelo Huaraca"))){
            logger.info("test failed");
            captureScreen(driver,"payOnlineWithLogin");
            Assert.assertTrue(false);
        }

        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(5000);

        hp.addAnPopularProductToCart();
        Thread.sleep(3000);
        hp.clickBtnProccedToCheckout();
        Thread.sleep(5000);

        OrderPage op = new OrderPage(driver);
        op.clickBtnProceedToCheckoutOrder();
        Thread.sleep(3000);
        op.clickBtnProceesAddress();
        Thread.sleep(3000);
        op.clickChbxTermsOfService();
        op.clickBtnProceesCarrier();
        Thread.sleep(3000);
        op.clickPayMethod("bankwire");
        op.clickBtnConfirmOrder();
        Thread.sleep(5000);

        if (!(op.getTxtOrderComplete().equals("Your order on My Store is complete."))){
            logger.info("test failed");
            captureScreen(driver,"payOnlineWithLogin");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
