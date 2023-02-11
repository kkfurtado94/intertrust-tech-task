package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static manager.BaseTest.getDriver;

public abstract class AbstractPage {

    final static String DEFAULT_URL = "https://www.visualcrossing.com";

    public AbstractPage(){
        PageFactory.initElements(getDriver(), this);
    }
    protected void waitForElementClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
