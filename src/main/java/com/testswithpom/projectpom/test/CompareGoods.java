package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.*;
import org.junit.Test;

public class CompareGoods extends BaseClass {

    /**
     * Sign in and compare goods
     *
     */

    @Test
    public void compareGoods() throws InterruptedException {

        // Open site
        HomePage homePage = openSite();

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();

        //Click Login button
        AccountPage accountPage = loginPage.fillInputOnLoginPage();

        //Click on Dresses link
        ListingPage listingPage = accountPage.clickOnDressesLink();

        //Click on Summer Dresses link
        SubcategoryPage subcategoryPage = listingPage.clickOnSummerDressesLink();

        //Compare amount
       // subcategoryPage.compareProducts();

        //Click on White Color
        subcategoryPage.clickOnColor();

        //Compare amount with White color filter
//        subcategoryPage.compareProducts();

        //Sign Out
    //    accountPage.signOut();

        // Close site
      //  closeSite();
    }


}
