package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Utility {

    protected WebDriver driver;
    public Utility(WebDriver driver)
    {
        this.driver=driver;
    }
    public void pollingWait(List<WebElement> elements)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url)
    {
        driver.get(url);
    }

}
