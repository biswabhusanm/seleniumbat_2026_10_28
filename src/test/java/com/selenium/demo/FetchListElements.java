package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FetchListElements {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");//hitting the url
        driver.manage().window().maximize();
        WebElement text =driver.findElement(By.xpath("//h1[contains(text(),'Data, Tables & Button States')]"));
         if(text.isDisplayed())
         {
             System.out.println(text.getText().trim());
         }

        driver.quit();
    }
}
