package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOveropeartion {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Actions/index.html#");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();//maximize my window
      //WebElement chooselang =driver.findElement(By.xpath("//div[@id='icp-nav-flyout']/a"));
      //WebElement dc =driver.findElement(By.xpath("//div[@id='double-click']"));
//      WebElement src = driver.findElement(By.id("draggable"));
//      WebElement dest=driver.findElement(By.id("droppable"));
      // WebElement hold =driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        Actions act=new Actions(driver);
        Thread.sleep(3000);
        act.contextClick(driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"))).build().perform();
       // act.clickAndHold(hold).build().perform();
//        act.dragAndDrop(src,dest).build().perform();

    //    act.doubleClick(dc).build().perform();
     // act.moveToElement(chooselang).build().perform();
      Thread.sleep(2000);
     // driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//ul/li[8]/a/span/span[1]")).click();
      driver.quit();
    }
}
