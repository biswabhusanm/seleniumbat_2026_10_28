package com.selenium.demo;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        Set<String> allwindowID=driver.getWindowHandles();
        Iterator<String> it=allwindowID.iterator();
        while(it.hasNext())
        {
            String parenwindowid=it.next();
           String childwindowid= it.next();
           driver.switchTo().window(childwindowid);
        }
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.linkText("Solutions")).click();
        Thread.sleep(2000);
        driver.close();
    }


}
