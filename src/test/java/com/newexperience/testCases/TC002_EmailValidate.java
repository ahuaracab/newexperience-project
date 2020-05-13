package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_EmailValidate extends BaseClass {

    @Test
    public void emailValidate() throws InterruptedException, IOException {

        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);
        hp.clickLnkSignin();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))) {
            logger.info("test failed");
            captureScreen(driver,"emailValidate");
            Assert.assertTrue(false);
        }

        SigninPage sp = new SigninPage(driver);
        sp.setTxtEmailCreate("ahuaracab336@mailinator.com");
        sp.clickBtnCreateAccount();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"))){
            logger.info("test failed");
            captureScreen(driver,"emailValidate");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
