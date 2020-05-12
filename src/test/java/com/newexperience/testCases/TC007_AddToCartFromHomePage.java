package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_AddToCartFromHomePage extends BaseClass {

    @Test
    public void addToCartFromHomePage() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.addAllPopularProductToCart();

        Assert.assertEquals(hp.getTxtQuantityProductInCart(), hp.getCountPopularProduct());
    }
}
