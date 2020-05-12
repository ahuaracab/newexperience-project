package com.newexperience.testCases;

import com.newexperience.pageObjects.ContactUsPage;
import com.newexperience.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_ContactUs extends BaseClass {

    @Test
    public void contactUs() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkContactUs();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=contact"))) {
            logger.info("NO SE REDIRECCIONO A LA PAGINA DE CONTACTO");
            Assert.assertTrue(false);
        }

        ContactUsPage cup = new ContactUsPage(driver);
        cup.clickCbxSelectState("Webmaster");
        cup.setTxtEmail("ahuaracab123@mailinator.com");
        cup.setTxtMessage("no puedo recuperar mi contrasena");
        cup.clickBtnSubmitMessage();
        Thread.sleep(5000);

        Assert.assertEquals(cup.getTxtContactAlert(), "Your message has been successfully sent to our team.");
    }
}
