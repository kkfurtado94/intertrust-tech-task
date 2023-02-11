package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static manager.BaseTest.getDriver;

public class PageElements extends AbstractPage {

    public PageElements() {
        super();
        getDriver().get(DEFAULT_URL);
        PageFactory.initElements(getDriver(), this);
        waitForElementClickable(cookieAccept);
    }

    @FindBy(xpath = "//*[@class='btn btn-sm btn-primary col-lg-3']")
    private WebElement cookieAccept;

    @FindBy(css = "#navbarNav > ul > li:nth-child(1) > a")
    private WebElement weatherData;

    @FindBy(xpath = "//*[@id='wxlocation']")
    private WebElement searchField;

    @FindBy(css = "#wxdataform > div.d-sm-flex > button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='locationDropdownMenuButton']")
    private WebElement location;

    public void acceptCookies(){
        waitForElementClickable(cookieAccept);
        cookieAccept.click();
    }

    public void clickWeatherData(){
        waitForElementClickable(weatherData);
        weatherData.click();
    }

    public void typeCity(String cityName){
        waitForElementClickable(searchField);
        searchField.sendKeys(cityName);
    }

    public void clickSearch(){
        waitForElementClickable(searchButton);
        searchButton.click();
    }

    public String locationValidation(){
        return location.getText();
    }

    public boolean locationValidatePresence(){
        return location.isDisplayed();
    }

}
