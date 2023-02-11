package manager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
    protected static RemoteWebDriver driver;

    private static void initWebDriver() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
    }
    @AfterEach
    void teardown() {
        if (null != driver) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
    public static RemoteWebDriver getDriver(){
        if(driver == null){
            initWebDriver();
        }
        return driver;
    }
}
