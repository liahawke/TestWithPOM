package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccountPage extends AbstractPage{

    // Title of Python page
    private final String USERNAME = "Lia Hawke";

    @FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutLink;

    @FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    private WebElement userName;

    @FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement dressesLink;

    @FindBy (xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")
    private WebElement summerDressesLink;

    @FindBy (xpath = "//span[@class='heading-counter']")
    private WebElement numInMessage;


    public AccountPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    public void clickOnDressesLink(){ dressesLink.click(); }

    public void clickOnSummerDressesLink(){ summerDressesLink.click(); }

    public void verifyName(){
        Assert.assertEquals("User name is wrong", USERNAME, userName.getText());
    }

    public void signOut(){
        signOutLink.click();
    }

    public void compareProducts(List <WebElement> liElements){
        Assert.assertEquals("Amount of products is not equal", "There are "+ liElements.size() + " products.", numInMessage.getText());
    }
}
