package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    @FindBy (xpath = "//a[@title='Log me out']")
    private WebElement signOutLink;

    @FindBy (xpath = "//div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='Dresses']")
    private WebElement dressesLink;

    @FindBy (xpath = "//div[@class='block_content']/ul[@class='tree dynamized']//a[contains(text(),'Summer Dresses')]")
    private WebElement summerDressesLink;

    private String AUTH_TITLE = "Login - My Store";

    // Instances of BaseTest
    protected BaseClass testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseClass testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on Sign in link
     *
     * @return Login Page
     */
    public LoginPage clickLoginLink() {
        testClass.waitTillElementIsVisible(loginLink);
        loginLink.click();
        return new LoginPage(testClass);
    }

    /**
     * Click on Sign out link
     *
     */
    public void signOut(){
        signOutLink.click();
    }

    /**
     * Click on Dresses link
     *
     */
    public ListingPage clickOnDressesLink(){
        dressesLink.click();
        return new ListingPage(testClass);
    }

    /**
     * Check title of AUTHENTICATION page
     *
     */
    public void checkTitle(){
        Assert.assertEquals("Page is different", testClass.getDriver().getTitle(), AUTH_TITLE);
    }
}
