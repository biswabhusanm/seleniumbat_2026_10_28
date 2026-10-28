package testngdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PracticalUsecaseOfAnnotation {
    WebDriver driver;
    @BeforeTest(enabled = true)
    public void beforeTest()
    {
        System.out.println("initilizing db connection");
    }
    @BeforeClass(enabled = true)
    public void classrunstarts()
    {
        System.out.println("my classes started running");
    }
    @BeforeMethod(enabled = true,groups = {"smoke","regression"})
    public void launchUrl() throws InterruptedException {
        driver=new ChromeDriver();//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");//hitting the url
        driver.manage().window().maximize();//maximize my window
        Thread.sleep(2000);
    }


    @Test(groups = {"smoke","regression"},invocationCount = 2)
    public void fillingForm() throws InterruptedException {

        driver.findElement(By.name("first_name")).sendKeys("aaa");//fetch text from the ui
        driver.findElement(By.name("last_name")).sendKeys("aaa");
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.name("message")).sendKeys("aaa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        String txt=driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']")).getText();
        System.out.println(txt);

    }



    @Test(groups = {"regression"})

    public void resetForm() throws InterruptedException {

        driver.findElement(By.name("first_name")).sendKeys("aaa");//fetch text from the ui
        driver.findElement(By.name("last_name")).sendKeys("aaa");
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.name("message")).sendKeys("aaa");
        driver.findElement(By.xpath("//input[@type='reset']")).click();
        Thread.sleep(3000);
       String placeholdername= driver.findElement(By.name("first_name")).getAttribute("placeholder");
       //Assert.assertEquals(placeholdername,"last Name");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(placeholdername,"last Name");
        System.out.println("test executed");
        softAssert.assertTrue(driver.findElement(By.xpath("//input[@type='reset']")).isDisplayed());
        softAssert.assertAll();

    }
    @Test(groups = {"regression","smoke"})
    public void testDemo()
    {

        System.out.println("hii this is test 3");
    }
    @AfterMethod(enabled = true,groups = {"smoke","regression"})
    public void quitBrowser()
    {
        driver.quit();
    }
}
