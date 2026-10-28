package testngdem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindBrokenLink {
    HttpURLConnection httpConn;
    WebDriver driver;
    @Test()
    public void brokenLinkFind() throws InterruptedException {
         driver=new ChromeDriver();
        int brokenLinkCount = 0;
    //    HttpsURLConnection httpConn = null;
        driver.get("https://demoqa.com/broken");//we have created reference for webdriver interface,because webdriver is interface so we cant create object,thats why we are creating object for its child class
        Thread.sleep(2000);
        driver.manage().window().maximize();
        List< WebElement> allLinks =driver.findElements(By.tagName("a"));
        System.out.println("all links count is " +allLinks.size());
        for (int i = 0; i < allLinks.size(); i++) {
          String  allUrls=allLinks.get(i).getAttribute("href");
          if(allUrls==null || allUrls.isEmpty())
          {
              System.out.println("skipping the urls"+allUrls);
          }
          try{
              URL url=new URL(allUrls);
               httpConn= (HttpURLConnection) url.openConnection();//created  a connection
              httpConn.connect();//connected with apis call
             int responseCode= httpConn.getResponseCode();//get all response code
              if(responseCode>=400)
              {
                  System.out.println("this link is broken " +allUrls);
                  brokenLinkCount++;
              }
              else{
                  System.out.println("this is valid link "+allUrls);
              }
          }
          catch (MalformedURLException e) {
              throw new RuntimeException(e);
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          finally
              {

               httpConn.disconnect();

              }
          }

        System.out.println("number of links broken= "+brokenLinkCount);

        }

        @AfterMethod
        public void quitBrowser()
        {
            driver.quit();
        }


}
