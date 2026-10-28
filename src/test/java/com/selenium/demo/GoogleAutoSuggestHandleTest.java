package com.selenium.demo;

import browsersetup.BaseTest;
import config.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleAutoSuggestPage;
import utility.Utility;

public class GoogleAutoSuggestHandleTest extends BaseTest {
    @BeforeMethod
    public void enterUrl()
    {
        Utility util=new Utility(getDriver());
        util.enterUrl(ConfigReader.getProp("googleUrl"));
    }

    @Test
    public void verifyAutoSuggestScenario()
    {
        GoogleAutoSuggestPage gap=new GoogleAutoSuggestPage(getDriver());
        gap.enterSearchText("Sachin");
        gap.selectingValueFromAutoSuggest("Sachin pilot");
    }
}
