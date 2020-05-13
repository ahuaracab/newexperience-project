package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.OrderPage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC008_PayOnlineWithoutLogin extends BaseClass{

    @Test
    public void payOnlineWithoutLogin() throws InterruptedException, IOException {
        HomePage hp = new HomePage(driver);
        hp.addAnPopularProductToCart();
        Thread.sleep(3000);
        hp.clickBtnProccedToCheckout();
        Thread.sleep(5000);

        OrderPage op = new OrderPage(driver);
        op.clickBtnProceedToCheckoutOrder();
        Thread.sleep(3000);

        SigninPage sip = new SigninPage(driver);
        sip.setTxtEmail("ahuaracab123@mailinator.com");
        sip.setTxtPasswd("123465789");
        sip.clickBtnSubmitLogin();

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
            captureScreen(driver,"payOnlineWithoutLogin");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}