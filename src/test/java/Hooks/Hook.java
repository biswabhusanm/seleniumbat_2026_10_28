package Hooks;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    public static WebDriver driver;
    @Before
    public void setUp()
    {
        System.out.println("driver initialized");
        driver=new ChromeDriver();
    }
    @BeforeStep
    public void executeBeforeEachScenarioStep(Scenario scenario)
    {
        System.out.println(""+scenario.getName());
    }
    @AfterStep()
    @Given("user is in orangehrm login screen")
    public void user_is_in_orangehrm_login_screen() {

        System.out.println("user is about o login");
    }
    @When("user navigating to orangehrm url")
    public void user_navigating_to_orangehrm_url() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @After
    public void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
