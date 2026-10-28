package testngdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class OrangeHRMDemoLogin {
  WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchUrl(ITestContext context) throws InterruptedException {
        driver = new ChromeDriver();
        context.setAttribute("driver",driver);//setting the driver

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//hitting the url
       // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();//maximize my window
        Thread.sleep(2000);
    }
    @Test(dataProviderClass = DataproviderTest.class,dataProvider = "readdatafromexcel")
    public void orangeHrmloginTest(String username,String password)
    {
        System.out.println(username);
        System.out.println(password);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Test(dataProviderClass = DataproviderTest.class,dataProvider = "fetchInvaliddata",retryAnalyzer = TestListener.class)
    public void loginWithInvalidData(String username,String password)
    {
        System.out.println(username);
        System.out.println(password);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestContext context) throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        context.setAttribute("driver",driver);//setting the driver

    }



}
