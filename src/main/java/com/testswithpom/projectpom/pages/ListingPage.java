package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListingPage extends AbstractPage{

    // Web elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement numInMessage;

    @FindBy (xpath="//a[contains(text(),'White')]")
    private WebElement colorWhite;

    /**
     * Constructor
     *
     * @param testClass
     */

    public ListingPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Compare counter of Products
     *
     *
     * @param liElements
     */

    public void compareProducts(List<WebElement> liElements){
        Assert.assertEquals("Amount of products is not equal", "There are "+ liElements.size() + " products.", numInMessage.getText());
    }

    /**
     * Click on link with color filter
     *
     */

    public void clickOnColor(){ colorWhite.click(); }
}
