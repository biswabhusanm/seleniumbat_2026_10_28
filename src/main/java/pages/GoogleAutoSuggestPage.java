package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Utility;

import java.util.List;

public class GoogleAutoSuggestPage extends BasePage{

    public GoogleAutoSuggestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@role='presentation']/span[contains(text(),'Sachin')]")
    private List<WebElement> autoSuugestValue;

    public void enterSearchText(String value)
    {
        searchBox.sendKeys(value);
    }
    public void selectingValueFromAutoSuggest(String value)
    {
        Utility util=new Utility(driver);
        util.pollingWait(autoSuugestValue);
        String expText=value;
        for (int i = 0; i <autoSuugestValue.size() ; i++) {
            System.out.println(autoSuugestValue.get(i).getText().trim());
            if(autoSuugestValue.get(i).getText().trim().equalsIgnoreCase(expText))
            {
                autoSuugestValue.get(i).click();
                break;
            }
        }
    }
}
