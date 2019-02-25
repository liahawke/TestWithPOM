package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {


    @FindBy(xpath="//*[@id=\"email\"]")
    private WebElement loginInput;

    @FindBy(xpath="//*[@id=\"passwd\"]")
    private WebElement passwordInput;


    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    public void fillInputOnLoginPage(){
        loginInput.click();
        loginInput.sendKeys(YamlParser.getYamlData().getEmail());
        passwordInput.click();
        passwordInput.sendKeys(YamlParser.getYamlData().getPassword());
    }

}
