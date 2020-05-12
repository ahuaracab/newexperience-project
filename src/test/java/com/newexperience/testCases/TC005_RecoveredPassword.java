package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.RecoveredPasswordPage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_RecoveredPassword extends BaseClass {

    @Test
    public void recoveredPassword() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkSignin();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))) {
            logger.info("NO SE REDIRECCIONO A LA PAGINA DE SIGNIN");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(3000);

        sip.clickLnkLostPassword();
        Thread.sleep(5000);

        RecoveredPasswordPage rpp = new RecoveredPasswordPage(driver);
        Thread.sleep(3000);
        rpp.setTxtEmail("ahuaracab123@mailinator.com");
        rpp.clickBtnSubmitEmail();
        Thread.sleep(5000);
        Assert.assertEquals(rpp.getTxtEmailAlert(), "A confirmation email has been sent to your address: ahuaracab123@mailinator.com");
    }
}
