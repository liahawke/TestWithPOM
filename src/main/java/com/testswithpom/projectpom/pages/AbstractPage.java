package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement loginLink;


    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;


    @FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
    private WebElement loginBtn;

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


    public LoginPage clickLoginLink() {
        testClass.waitTillElementIsVisible(loginLink);
        loginLink.click();
        return new LoginPage(testClass);
    }


    public AccountPage clickLoginBtn() {
        loginBtn.click();
        return new AccountPage(testClass);
    }

}
