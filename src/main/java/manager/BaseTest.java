package manager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;


    static void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public static WebDriver getDriver(){
        if(driver == null){
            setup();
        }
        return driver;
    }
}
