package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.RecoveredPasswordPage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC005_RecoveredPassword extends BaseClass {

    @Test
    public void recoveredPassword() throws InterruptedException, IOException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkSignin();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))){
            logger.info("test failed");
            captureScreen(driver,"recoveredPassword");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(3000);

        sip.clickLnkLostPassword();
        Thread.sleep(5000);

        RecoveredPasswordPage rpp = new RecoveredPasswordPage(driver);
        Thread.sleep(3000);
        rpp.setTxtEmail("ahuaracab333@mailinator.com");
        rpp.clickBtnSubmitEmail();
        Thread.sleep(5000);

        if (!(rpp.getTxtEmailAlert().equals("A confirmation email has been sent to your address: ahuaracab333@mailinator.com"))){
            logger.info("test failed");
            captureScreen(driver,"recoveredPassword");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
