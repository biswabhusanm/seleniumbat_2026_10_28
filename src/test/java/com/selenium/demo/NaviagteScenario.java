package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaviagteScenario {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");//hitting the url
        driver.manage().window().maximize();//maximize my window
        Thread.sleep(2000);
      driver.findElement(By.name("first_name")).sendKeys("aaa");//fetch text from the ui
        driver.findElement(By.name("last_name")).sendKeys("aaa");
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.name("message")).sendKeys("aaa");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        String txt=driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']")).getText();
        System.out.println(txt);

//       if(contactUS.equalsIgnoreCase("contact us"))
//       {
//           System.out.println("tc passed");
//       }
//       else{
//           System.out.println("tc failed");
//       }
//       String placeholder= driver.findElement(By.xpath("//input[@type='text'][1]")).getAttribute("placeholder");
//        System.out.println(placeholder);
      driver.quit();

    }
}
