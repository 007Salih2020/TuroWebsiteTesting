package com.turo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainPage extends Base{
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    @FindBy(xpath = "//*[name()='use' and contains(@height,'72')]")
    public WebElement logo;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    public WebElement login;

    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    public WebElement signup;

    @FindBy(xpath = "//img[@alt='Liberty Mutual Insurance']")
    public WebElement insuranceLogo;

    public void verifyLogo() {
        logo.isDisplayed();
        logger.info("Turo logo is displayed");
    }

    String actual;
    public void verifyTheFields(String value) {
        if(value.equals(login.getText())){
            actual = login.getText();
            Assert.assertEquals(value, actual);
            logger.info("{} is displayed", value);
        }else if(value.equals(signup.getText())){
            actual = signup.getText();
            Assert.assertEquals(value, actual);
            logger.info("{} is displayed",actual);
        }else logger.warn("Error");
    }

    public void verifyInsuranceLogo() {
        insuranceLogo.isDisplayed();
        logger.info("Insurance logo is displayed");
    }
}
