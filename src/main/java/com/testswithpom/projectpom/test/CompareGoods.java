package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.AccountPage;
import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.pages.ListingPage;
import com.testswithpom.projectpom.pages.LoginPage;
import org.junit.Test;

public class CompareGoods extends BaseClass {

    /**
     * Sign in and compare goods
     *
     */

    @Test
    public void signInAndCheckName() {

        // Open site
        HomePage homePage = openSite();

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();

        //Fill valid creeds
        loginPage.fillInputOnLoginPage();

        //Click Login button
        AccountPage accountPage = loginPage.clickLoginBtn();

        //Click on Dresses link
        accountPage.clickOnDressesLink();

        //Click on Summer Dresses link
        accountPage.clickOnSummerDressesLink();

        //Create new instants of ListingPage
        ListingPage listingPage = new ListingPage(this);

        //Compare amount
        listingPage.compareProducts(getListOfElements());

        //Click on White Color
        listingPage.clickOnColor();

        //Compare amount with White color filter
        listingPage.compareProducts(getListOfElements());

        //Sign Out
        accountPage.signOut();

        // Close site
        closeSite();
    }


}
