package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactFormPage extends BasePage {


    @FindBy(name = "first_name")
    private WebElement firstnameField;

    @FindBy(name = "last_name")
    private WebElement lastnameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "message")
    private WebElement msgField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitCTA;

    public ContactFormPage(WebDriver driver) {

        super(driver);
    }


    public void enterFirstname(String value)
    {

        firstnameField.sendKeys(value);
    }

    public void enterLastname(String value)
    {
        lastnameField.sendKeys(value);
    }

    public void enterEmail(String value)
    {
        emailField.sendKeys(value);
    }
    public void enterMsg(String value)
    {
        msgField.sendKeys(value);
    }
    public void clickSubmitCTA()
    {
        msgField.click();
    }


}
