package com.selenium.demo;

import browsersetup.BaseTest;
import config.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import pages.ContactFormPage;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FillingFormDetails extends BaseTest {

    @Test
    public void verifyFillingFormFunctionality() throws IOException {
        ContactFormPage contactFormPage=new ContactFormPage(getDriver());

        contactFormPage.enterFirstname(JsonReader.readJsondata("firstname"));
        contactFormPage.enterLastname(JsonReader.readJsondata("lastname"));
        contactFormPage.enterEmail(JsonReader.readJsondata("email"));
        contactFormPage.enterMsg(JsonReader.readJsondata("msg"));
        contactFormPage.clickSubmitCTA();


    }

    }


