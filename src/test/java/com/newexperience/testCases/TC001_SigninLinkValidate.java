package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC001_SigninLinkValidate extends BaseClass {

    @Test
    public void signinLinkValidate() throws InterruptedException, IOException {
        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);

        hp.clickLnkSignin();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))){
            logger.info("test failed");
            captureScreen(driver,"signinLinkValidate");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}