package browsersetup;

import config.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



    public abstract class BaseTest {

        private WebDriver driver;

        public WebDriver getDriver() {

            return driver;
        }




        @BeforeMethod(alwaysRun = true)
        public void setUp() throws MalformedURLException {
            ChromeOptions options = new ChromeOptions();
            // (Optional) You can add arguments or capabilities if needed
            // options.addArguments("--headless"); // Example: run Chrome in headless mode
            // Initialize the RemoteWebDriver with Grid URL and Chrome options
            // driver = new RemoteWebDriver(new URL("http://192.168.0.9:4444"), options);
            driver=new ChromeDriver(options);
            driver.get(ConfigReader.getProp("appUrl"));
          //  driver.manage().window().maximize();
            Utility util=new Utility(getDriver());
            util.maximizeWindow();
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown()
        {
            try {
                if (driver != null) {
                    driver.quit();
                }
            }
            catch (Exception e)
            {
                driver.quit();
            }
        }

    }

