package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class AlertHandling {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        org.openqa.selenium.WebElement wb =driver.findElement(By.xpath("//"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);

    }
}
