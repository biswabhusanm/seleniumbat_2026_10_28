package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://webdriveruniversity.com/IFrame/index.html");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.switchTo().frame("frame");
        driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
