package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {

        return driver.get();
    }

    @BeforeClass
    public void appLaunch() throws InterruptedException {
        String location = System.getProperty("user.dir") + "/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", location);
        driver.set(new ChromeDriver());
        //WebDriverManager.chromedriver().version("73").setup();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().get("https://tauria.com/signin");
    }
    @AfterClass
    public void afterClass() {
        if (driver != null) {
            try {
                getDriver().close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static String generateUnique() {
        String uniqueText = UUID.randomUUID().toString();
        return uniqueText;
    }
}
