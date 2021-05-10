package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import com.turo.utils.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTheFirstCar extends Base{
    Logger logger = LoggerFactory.getLogger(SelectTheFirstCar.class);

    @FindBy(xpath = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[1]/div/div/a")
    public WebElement firstCarLink;

    @FindBy(xpath = "//*[@class='ey4g3ta0 css-1wmlurb-StyledText-VehicleLabelText']")
    public WebElement firstCarTitle;

//    @FindBy(xpath = "//p[@class=\"css-o0jrll-StyledText\"]")
    @FindBy(xpath = "//p[@class='css-w38rvm-StyledText']")
    public WebElement theCar;

    @FindBy(xpath = "//h1[@class=\"css-tibi9u-StyledText\"]")
    public WebElement selectedCarTitle;

    @FindBy(xpath = "//div[@class='reservationBoxLocation-current reservationBoxLocation-current--instantBook']")
    public WebElement pickupLocation;

//    @FindBy(xpath = "//span[@class='reservationBoxLocationOption reservationBoxLocationOption--home is-active']")
    @FindBy(xpath = "//span[@class='reservationBoxLocationOption reservationBoxLocationOption--home']")
    public WebElement pickup;

    @FindBy(xpath = "//span[@tabindex='0' and @xpath='1']")
    public WebElement deliveryLocation;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;


    public void selectTheFirstCarAndVerify() {
        waitSomeTime(5L);
        JavascriptExecutor js = (JavascriptExecutor) MyDriver.get();
        js.executeScript("arguments[0].setAttribute('target', '')", firstCarLink );
        String expected = firstCarTitle.getText();
        firstCarLink.click();

        waitSomeTime(10L);
        scrollDown(theCar);
        waitSomeTime(1000L);
        String actual = selectedCarTitle.getText();
        logger.info("Expected is {} and actual is {}.",expected, actual);
        Assert.assertEquals(expected, actual);
    }

    public void selectPickupLocation() {
        pickupLocation.click();
        pickup.click();
    }

    public void clickOnContinue() {
        waitSomeTime(5000L);
        continueButton.click();
    }
}
