package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Facebook_Page {
    private WebDriver driver;

    // 1. By Locators
    private By username = By.xpath("//*[@id=\'email\']");
    private By password = By.xpath("//*[@id=\'pass\']");
    private By loginButton = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button");


    // 2. Constructors

    public Facebook_Page() {

    }

    public Facebook_Page(WebDriver driver) {
        this.driver = driver;

    }


    //3. Page Actions


    public void enterUsername(String Username) {
        new WebDriverWait(driver, 20).until(visibilityOfElementLocated(username)).sendKeys(Username);

    }

    public void enterPassword(String Password) {
        new WebDriverWait(driver, 20).until(visibilityOfElementLocated(password)).sendKeys(Password);

    }

    public void clickOnLogin() {
        new WebDriverWait(driver, 20).until(visibilityOfElementLocated(loginButton)).click();

    }

}
