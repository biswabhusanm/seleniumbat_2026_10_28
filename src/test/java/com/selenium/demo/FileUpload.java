package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#text")).sendKeys("biswa");
      //  driver.findElement(By.id("uploadFile")).click();
       // driver.findElement(By.xpath("//div[@class='mt-5']")).click();
//        Thread.sleep(2000);
//        String filepath="C:\\Users\\hp\\Downloads\\participants.csv";
//        StringSelection ss=new StringSelection(filepath);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);//copy your filepath
//        Robot robot=new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(2000);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//       // driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\hp\\Downloads\\participants.csv");
//        Thread.sleep(2000);
       // driver.findElement(By.id("submit-button")).click();
       // Thread.sleep(2000);
        driver.quit();
    }
}
