package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListingPage extends AbstractPage{


    @FindBy (xpath = "//div[@class='block_content']/ul[@class='tree dynamized']//a[contains(text(),'Summer Dresses')]")
    private WebElement summerDressesLink;
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
     * Click on subcategory Summer Dresses link
     *
     */
    public SubcategoryPage clickOnSummerDressesLink(){
        summerDressesLink.click();
        return new SubcategoryPage(testClass);
    }

}
