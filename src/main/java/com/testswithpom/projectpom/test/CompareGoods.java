package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.AccountPage;
import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.pages.LoginPage;
import org.junit.Test;

public class CompareGoods extends BaseClass {
    /**
     * Sign in and compare goods
     * 3. Кликаем на Dresses, затем на Summer Dresses
     * 4. Сравниваем количество товаров на странице с тем числом что указано в сообщении
     * - There are %integer% products
     * 5. Кликаем на White в разделе Color
     * 6.  Сравниваем количество товаров на странице с тем числом что указано в сообщении
     * - There are %integer% products
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

        //Compare amount
        accountPage.compareProducts(getListOfElements());

        //Sign Out
        accountPage.signOut();

        // Close site
        closeSite();
    }


}
