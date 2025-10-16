package stepdef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static WebDriver driver;

    protected void getDriver() {
        /*configuration chrome version conflict*/
        WebDriverManager.chromedriver()
                .driverVersion("141.0.7390.66")  // Replace with correct version
                .setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Jalankan Chrome tanpa infobar & notifikasi
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //driver = WebDriverManager.chromedriver().create();
    }
}
