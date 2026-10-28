package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Autosuggest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
         Thread.sleep(2000);
         driver.manage().window().maximize();//maximize my window
        driver.findElement(By.name("q")).sendKeys("sachin");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//implicit wait
      //  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        List< WebElement> allsrchrslt =driver.findElements(By.xpath("//div[@role='presentation']/span[contains(text(),'Sachin')]"));
       wait.until(ExpectedConditions.visibilityOfAllElements(allsrchrslt));
        String expText="Sachin Pilot";
        for (int i = 0; i <allsrchrslt.size() ; i++) {
         System.out.println(allsrchrslt.get(i).getText().trim());
            if(allsrchrslt.get(i).getText().trim().equalsIgnoreCase(expText))
            {
                allsrchrslt.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
