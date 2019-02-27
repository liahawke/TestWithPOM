package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubcategoryPage extends AbstractPage{

    // Web elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement numInMessage;

    @FindBy (xpath="//a[contains(text(),'White')]")
    private WebElement colorWhite;

    @FindBy (xpath="//ul[@class='product_list grid row']/li")
    private  WebElement listOfDresses;

    String loaderString = "//*[@id='layered_ajax_loader']/p";
    /**
     * Constructor
     *
     * @param testClass
     */
    public SubcategoryPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Compare counter of Products
     *
     *
     */

    public void compareProducts(){
          List<WebElement> liElements = testClass.getDriver().findElements(By.xpath("//ul[@class='product_list grid row']/li"));
          Assert.assertEquals("Amount of products is not equal", "There are "+ liElements.size() + " products.", numInMessage.getText());
    }

    /**
     * Click on link with color filter
     *
     */

    public void clickOnColor() throws InterruptedException {
        testClass.waitTillElementBeClickable(colorWhite);
        colorWhite.click();
        testClass.waitUntilLoaderInvisible(loaderString);
    }
}
