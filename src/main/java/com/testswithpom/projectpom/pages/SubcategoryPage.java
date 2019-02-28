package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubcategoryPage extends AbstractPage{

    // Web elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement numInMessage;

    @FindBy (xpath="//input[@id='layered_id_attribute_group_8']")
    private WebElement colorWhite;

    @FindBy (xpath="//ul[@class='product_list grid row']/li")
    private  WebElement listOfDresses;

    @FindBy (xpath="//*[@id='enabled_filters']/ul/li")
    private WebElement filterWhite;

    String loaderString = "//*[@id='layered_ajax_loader']/p";

    String FILTER_NAME = "Color: White";

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
        testClass.waitTillElementIsVisible(listOfDresses);
        List<WebElement> liElements = testClass.getDriver().findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        if (liElements.size() == 1){
            Assert.assertEquals("Amount of products is not equal", "There is "+ liElements.size() + " product.", numInMessage.getText());
        }else {
            Assert.assertEquals("Amount of products is not equal", "There are "+ liElements.size() + " products.", numInMessage.getText());
        }
        System.out.println("There are "+ liElements.size() + " products.");
        System.out.println("Actual: " + numInMessage.getText());
    }

    /**
     * Check if filter was applied
     *
     */
    public void checkFilterApply(){
        Assert.assertEquals("Color filter White wasn't applied", FILTER_NAME, filterWhite.getText());
        System.out.println("Color " + filterWhite.getText());
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
