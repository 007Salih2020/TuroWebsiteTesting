package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import com.turo.utils.MyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Watchable;

public class AdvancedSearch extends Base{
    Logger logger = LoggerFactory.getLogger(AdvancedSearch.class);

    @FindBy(xpath = "//div[@class='searchFilter desktopMoreFilters']")
    public WebElement moreFiltersButton;

    @FindBy(css = "label[for='allStarHost'] span[class='styledCheckbox-label']")
    public WebElement allStarHost;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[7]//div[2]//div[1]//span[1]")
    public WebElement vehicleTypesButton;

    @FindBy(xpath = "//span[@class='imageMultiSelectOption-icon typeIcon typeIcon--car']")
    public WebElement car;

    @FindBy(xpath = "//select[@id='makes']")
    public WebElement vehicleMakes;

    @FindBy(xpath = "//option[@value='Lexus']")
    public WebElement lexus;

    @FindBy(xpath = "//span[@class='rangeSliderField-label']")
    public WebElement yearText;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1']")
    public WebElement leftYearSlider;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
    public WebElement rightYearSlider;

    @FindBy(xpath = "//select[@id='automaticTransmission']")
    public WebElement transmission;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult4;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[1]//button[1]")
    public WebElement sortBy;

    @FindBy(css = "label[for='styledRadioButtonField-sortType-PRICE_LOW']")
    public WebElement lowToHigh;

    @FindBy(xpath = "//button[@data-test='searchFilterPopupDesktop-submitButton']")
    public WebElement applyButton;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[2]//button[1]")
    public WebElement price;


    @FindBy(css = "div[class='rc-slider-handle rc-slider-handle-1']")
    public WebElement leftSlider;

    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
    public WebElement rightSlider;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[3]//button[1]")
    public WebElement bookInstantly;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult2;

    @FindBy(xpath = "//div[@class='searchFilterBar']//div[4]//button[1]")
    public WebElement deliveryButton;

    @FindBy(xpath = "//div[@role='slider']")
    public WebElement deliveryRightSlider;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement viewResult3;

    @FindBy(xpath = "//span[contains(text(), 'Distance included')]")
    public WebElement distanceButton;

    @FindBy(css = "label[for='styledRadioButtonField-minimumMileage-200']")
    public WebElement distance200miles;

    @FindBy(css = "button[class='buttonSchumi buttonSchumi--medium buttonSchumi--purple searchFilterPopupDesktop-submitButton']")
    public WebElement applyButton1;




    public void moreFilterOptions() {
        moreFiltersButton.click();
        allStarHost.click();
    }

    public void selectCarAndVehicleMakes(String vehicle_makes) {
        vehicleTypesButton.click();
        car.click();

        waitSomeTime(2L);
        Select select = new Select(vehicleMakes);
        scrollDown(lexus);
        waitSomeTime(2L);
        select.selectByVisibleText(vehicle_makes);
    }

    public void adjustYears() {
        scrollDown(yearText);

        Actions move = new Actions(MyDriver.get());

//        Action actionLeft1 = (Action) move.moveToElement(rightSlider, 430, 0) dragAndDropBy(leftYearSlider, 430, 0).release().build();
        Action actionLeft1 = (Action) move.dragAndDropBy(leftYearSlider, 430, 0).release().build();
        ((Action) actionLeft1).perform();

        Action actionLeft = (Action) move.dragAndDropBy(rightYearSlider, -15, 0).release().build();
        ((Action) actionLeft).perform();
    }
    public void selectTransmission() {
        Select select = new Select(transmission);
        waitSomeTime(2L);
        select.selectByVisibleText("Automatic");

        waitSomeTime(2L);
        viewResult4.click();
    }

    public void clickOnSortBy() {
        waitSomeTime(5L);
        sortBy.click();
        lowToHigh.click();
        System.out.println(lowToHigh.getText() + " is Selected...");
        applyButton.click();
        waitSomeTime(2L);
    }

    public void clickOnPrice() {

        price.click();
        Actions move = new Actions(MyDriver.get());
        // We can get coordinate with coordinates extension in google chrome.
        // Left slider move to 50$. x coordinate is moving 68 pixel to right from left.
        Action actionLeft = move.dragAndDropBy(leftSlider, 68, 234).build();
        actionLeft.perform();

        // Right slider move to 200$. x coordinate is moving -90 pixel   to left from right.
        Action actionRight = (Action) move.dragAndDropBy(rightSlider, -90, 234).build();
        ((Action) actionRight).perform();

        viewResult.click();
        waitSomeTime(2L);
    }

    public void clickOnBookInstant() {
        bookInstantly.click();
        viewResult2.click();
        waitSomeTime(2L);
    }
    public void adjustDeliveryOption() {
        deliveryButton.click();
        Actions move = new Actions(MyDriver.get());

        Action actionRight =  move.dragAndDropBy(deliveryRightSlider, -105, 234).build();
        actionRight.perform();
        waitSomeTime(2L);
        viewResult3.click();
    }

    public void distanceIncludedOption() {
        waitSomeTime(2L);
        distanceButton.click();
        distance200miles.click();
        waitSomeTime(2L);
        applyButton1.click();
    }











//    @FindBy(xpath = "//div[@class='searchFilter desktopMoreFilters']")
//    public WebElement moreFiltersButton;
//
//    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1']")
//    public WebElement left;
//
//    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-1 rc-slider-handle-click-focused']")
//    public WebElement leftSlider;
//
//    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2']")
//    public WebElement right;
//
//    @FindBy(xpath = "//div[@class='rc-slider-handle rc-slider-handle-2 rc-slider-handle-click-focused']")
//    public WebElement rightSlider;
//
//    @FindBy(xpath = "//div[@class='rc-slider-track rc-slider-track-1']")
//    public WebElement slider;
//
//    @FindBy(xpath = "//span[@class='rangeSliderField-label']")
//    public WebElement yearText;



}
