package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement alfruits = driver.findElement(By.id("fruit-selects"));
        Select sel = new Select(alfruits);
        List<WebElement> allFruitsfromdropdown = sel.getOptions();
        for (int i = 0; i < allFruitsfromdropdown.size(); i++) {
            System.out.println(allFruitsfromdropdown.get(i).getAttribute("outerHTML"));
            if (allFruitsfromdropdown.get(i).getAttribute("outerHTML").contains("disabled")) {
                System.out.println(allFruitsfromdropdown.get(i).getText().trim());
                break;
            }
            }
            Thread.sleep(2000);
            driver.quit();

        }
    }

