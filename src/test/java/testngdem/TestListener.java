package testngdem;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener, IRetryAnalyzer {

    private int retrycount=0;
    private static final int maxRetry=2;
    @Override
    public boolean retry(ITestResult result) {
        System.out.println("retrying this testcase "+result.getName());
        if(retrycount<=maxRetry)//0<2
        {
            retrycount++;
            return true;
        }
        retrycount=0;
        return false;

    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("this testcase failed "+result.getName());
       WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        TakesScreenshot ts=(TakesScreenshot) driver;
       File src= ts.getScreenshotAs(OutputType.FILE);//screenshot from selenium in file format
       String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());//getting the timstamp from local machine
        String screenshotname= result.getName()+"_"+timestamp+".png";//testcasename_20261015_802.png
        File destination= new File("./screenshots/"+screenshotname);//destination path
        try {
            FileUtils.copyFile(src,destination);
            System.out.println("screenshot captured" +destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
