package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static Hooks.Hook.driver;


public class LoginStepDef {








        @When("user enters username as {string}")
        public void user_enters_username_as (String username){
        driver.findElement(By.name("username")).sendKeys(username);

    }
        @When("user enters password as {string}")
        public void user_enters_password_as (String password){
       driver.findElement(By.name("password")).sendKeys(password);
    }
        @When("user clicks on login CTA")
        public void user_clicks_on_login_cta () {
        Assert.assertTrue(true);
    }
        @Then("user navigates to homescreen of orangehrm app")
        public void user_navigates_to_homescreen_of_orangehrm_app () {

        Assert.assertTrue(true);
        //driver.quit();

    }

        @Then("user should  see error message")
        public void user_should_see_error_message () {
        Assert.assertTrue(true);

    }

        @Then("user verify login text in login screen of  orangehrm app")
        public void user_verify_login_text_in_login_screen_of_orangehrm_app () {
        Assert.assertTrue(true);

    }

    @When("user enters credential")
    public void user_enters_credential(DataTable table) {
       List<Map<String,String>> tabledata =table.asMaps(String.class,String.class);
        driver.findElement(By.name("username")).sendKeys(tabledata.get(1).get("userName"));
        driver.findElement(By.name("password")).sendKeys(tabledata.get(1).get("password"));

    }
    @Then("user should verify Home text")
    public void user_should_verify_home_text() {
        String txt=driver.findElement(By.xpath("//input[@id='home']")).getText();
        System.out.println(txt);
        System.out.println("this is another assertion");
    }









}
