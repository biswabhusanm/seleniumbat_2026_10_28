package testngdem;

import config.ConfigReader;
import dev.reportinglabs.core.annotations.Owner;
import dev.reportinglabs.core.annotations.Priority;
import dev.reportinglabs.core.annotations.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AmazonSearch {
  WebDriver driver;

  @Owner("Biswa")
  @Priority("P1")
  @Story("JIRA-1234")
  @Test(groups = {"smoke"})
  public void hiautoSuggesionScenario() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get(ConfigReader.getProp("googleUrl"));//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
    Thread.sleep(2000);
    driver.manage().window().maximize();//maximize my window
    try {
      driver.findElement(By.name("q")).sendKeys("sachin");
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//implicit wait
      //  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
      Wait<WebDriver> wait = new FluentWait<>(driver)
              .withTimeout(Duration.ofSeconds(20))
              .pollingEvery(Duration.ofSeconds(1))
              .ignoring(NoSuchElementException.class);

      List<WebElement> allsrchrslt = driver.findElements(By.xpath("//div[@role='presentation']/span[contains(text(),'Sachin')]"));

      String expText = "Sachin Pilot";
      for (int i = 0; i < allsrchrslt.size(); i++) {
        wait.until(ExpectedConditions.visibilityOf(allsrchrslt.get(i)));
        System.out.println(allsrchrslt.get(i).getText().trim());
        if (allsrchrslt.get(i).getText().trim().equalsIgnoreCase(expText)) {
          allsrchrslt.get(i).click();
          break;
        }
      }
      Thread.sleep(2000);
    } finally {
      driver.quit();
    }


  }


  @Parameters("browser")
  @Test(groups = {"regression"})
  public void fillingForm(String browser) throws InterruptedException {
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    }
    else {
      System.setProperty(
              "webdriver.edge.driver",
              "C:\\Users\\hp\\Downloads\\edgedriver_win64\\msedgedriver.exe"
      );
      driver=new EdgeDriver();
      //we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
      driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");//hitting the url
      driver.manage().window().maximize();//maximize my window
      Thread.sleep(2000);
      driver.findElement(By.name("first_name")).sendKeys("aaa");//fetch text from the ui
      driver.findElement(By.name("last_name")).sendKeys("aaa");
      driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
      driver.findElement(By.name("message")).sendKeys("aaa");
      driver.findElement(By.xpath("//input[@type='submit']")).click();
      Thread.sleep(3000);
      String txt = driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']")).getText();
      System.out.println(txt);
      driver.quit();
    }


  }

  @Parameters("browser")
  @Test(groups = {"parallel"})
  public void fillingFormparallel(String browser) throws InterruptedException {

    if(browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    }
    else {
      driver = new FirefoxDriver();
    }
      //we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
      driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");//hitting the url
      driver.manage().window().maximize();//maximize my window
      Thread.sleep(2000);
      driver.findElement(By.name("first_name")).sendKeys("aaa");//fetch text from the ui
      driver.findElement(By.name("last_name")).sendKeys("aaa");
      driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
      driver.findElement(By.name("message")).sendKeys("aaa");
      driver.findElement(By.xpath("//input[@type='submit']")).click();
      Thread.sleep(3000);
      String txt = driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']")).getText();
      System.out.println(txt);
      driver.quit();
    }


  }




