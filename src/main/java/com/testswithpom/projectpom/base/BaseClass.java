package com.testswithpom.projectpom.base;

import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BaseClass {
    private WebDriver driver;
    private WebDriverWait wait;

    private String AUTH_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    /**
     * Constructor
     *
     */
    public BaseClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */

    public HomePage openSite() {
        driver.get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /**
     * Close site with driver.quit()
     */
    public void closeSite() {
        driver.quit();
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void checkURL(){
        Assert.assertEquals("Page is different", driver.getCurrentUrl(), AUTH_URL);
    }

    public List <WebElement> getListOfElements(){
        List<WebElement> liElements = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        System.out.println(liElements.size());
        return liElements;
    }


}

