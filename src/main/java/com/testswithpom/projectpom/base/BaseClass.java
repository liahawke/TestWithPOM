package com.testswithpom.projectpom.base;

import com.testswithpom.projectpom.pages.HomePage;
import com.testswithpom.projectpom.utils.YamlParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath="//*[@id='layered_ajax_loader']/p")
    private WebElement loader;

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
     * Return instance of Wait
     *
     * @return WebDriverWait
     */
    public WebDriverWait getWait() {
        return wait;
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

    /**
     * Wait till element be clikable
     *
     * @param element
     */
    public void waitTillElementBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until loader is invisible
     *
     * @param loader
     */
    public void waitUntilLoaderInvisible(String loader) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}

