package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class DriverUtil {

    public static WebDriver startCromeDriver() {
        ChromeDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;

        } catch (Exception e) {
            driver.quit();
            fail();
        }
        return null;
    }
}
