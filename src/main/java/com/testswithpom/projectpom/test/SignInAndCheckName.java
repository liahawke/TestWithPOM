package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.AccountPage;
import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.pages.LoginPage;
import org.junit.Test;

public class SignInAndCheckName extends BaseClass {

    /**
     * Sign in and check name
     */
    @Test
    public void signInAndCheckName() {

        // Open site
        HomePage homePage = openSite();

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();

        //Signing in Account
        AccountPage accountPage = loginPage.fillInputOnLoginPage();

        //Verify user name
        accountPage.verifyName();

        //Sign Out
        accountPage.signOut();

        //Check URL
        homePage.checkTitle();

        // Close site
        closeSite();
    }

}
