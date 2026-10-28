package testngdem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class HandlingShadowDom {

    @Test(groups = {"smoke"},invocationCount = 5,description = "handling shadow dom element")
    public void hiautoSuggesionScenario() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("chrome://settings/");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();//maximize my window
        ObjectMapper objectMapper=new ObjectMapper();//create object for ObjectMapper
        JsonNode jsonNode=objectMapper.readTree(new File("src/test/resources/Testdata/testdata.json"));//reading the json from json file
        String name=jsonNode.at("/home/0/road").asText();
        driver.findElement(By.cssSelector("settings-ui")).getShadowRoot().findElement(By.cssSelector("#toolbar")).getShadowRoot().findElement(By.cssSelector("#centeredContent")).findElement(By.cssSelector("#search")).getShadowRoot().findElement(By.cssSelector("#searchTerm")).findElement(By.cssSelector("#searchInput")).sendKeys(name);
       //driver.findElement(By.xpath("//input[@placeholder=\"Enter any value\"]")).sendKeys("biswa");
        Thread.sleep(2000);
        driver.quit();
    }


}
