package com.newexperience.testCases;

import com.newexperience.pageObjects.AccountPage;
import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC004_Login extends BaseClass {

    @Test
    public void login() throws InterruptedException, IOException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkSignin();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))){
            logger.info("test failed");
            captureScreen(driver,"login");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(5000);
        sip.setTxtEmail("ahuaracab333@mailinator.com");
        sip.setTxtPasswd("123456789");
        sip.clickBtnSubmitLogin();

        Thread.sleep(5000);

        AccountPage ap = new AccountPage(driver);
        Thread.sleep(3000);

        if (!(ap.getLnkAccountName().equals("Angelo Huaraca"))){
            logger.info("test failed");
            captureScreen(driver,"login");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
