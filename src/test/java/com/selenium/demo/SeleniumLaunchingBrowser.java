package com.selenium.demo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLaunchingBrowser {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        WebDriver driver1=new EdgeDriver();
        driver.get("https://www.amazon.com/");//hitting the url
        driver.manage().window().maximize();//maximize my window
        Thread.sleep(2000);
        String currentUrl=driver.getCurrentUrl();
       String pageTitle= driver.getTitle();
       String pagesrc=driver.getPageSource();
        System.out.println(pagesrc);
        System.out.println(pageTitle);
        if(pageTitle.contains("mode"))
        {
            System.out.println("tc passed");
        }
        else{
            System.out.println("tc failed");
        }
        System.out.println(currentUrl+" this is my current url of my applicatioon");
        driver.quit();//quit my browser
    }
}
