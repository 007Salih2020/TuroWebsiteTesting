package com.turo.pages;

import com.turo.stepdef.MainPageSteps;
import com.turo.utils.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchACar extends Base {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);
    MyDriver myDriver = new MyDriver();

    @FindBy(xpath = "//input[@id='searchFormLocationTypeahead-input']")
    public WebElement locationUser;

    @FindBy(xpath = "//div[@class='seo-pages-19ve007-SuggestionTextTitle ee6ccll1'][normalize-space()='Los Angeles, CA']")
    public WebElement selectLocation;

    @FindBy(xpath = "//input[@placeholder='Start date']")
    public WebElement startDate;

    @FindBy(xpath = "//div[@aria-label='Calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month']")
    public WebElement nextMonthClick;

    @FindBy(xpath = "//div[@class='DateRangePicker_picker DateRangePicker_picker__horizontal DateRangePicker_picker__with_header seo-pages-jonmmy']")
    public WebElement daysTable1;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;


    public void enterLocation(String location) {
        waitSomeTime(2L);
        locationUser.click();
        locationUser.sendKeys(location);
        selectLocation.click();
        logger.info("{} is entered.", location);
    }

    public void startDateAndTime(String dateFrom, String dateUntil) {
        //Clicking the calender element to open the calender.
        startDate.click();
        waitSomeTime(3L);

        while (!calendar.getText().contains("May 2021")) {
            //this will click till finding the moth April.
            waitSomeTime(3L);
            nextMonthClick.click();
            waitSomeTime(3L);
        }

        // SOLUTION 1 : Select date UNTIL - FROM and click

        //Grab common attribute and put it into list and iterate
        //using List to retrieve the class contains day in it.

        List<WebElement> dates2 = daysTable1.findElements(By.tagName("td"));

        for (WebElement day : dates2) {
//            System.out.println(day.getText());
            waitSomeTime(1L);
            if (day.getText().equals(dateFrom)) {

                day.click();
                logger.info("Start date {} is selected.", dateFrom);
            }
            waitSomeTime(3L);
            if (day.getText().equals(dateUntil)) {
                day.click();
                logger.info("End date {} is selected.", dateUntil);
                break;
            }
        }
        // SOLUTION 2 : Select date UNTIL - FROM and click
//        //counting the number of days inside the day class.
//        int count = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).size();
//
//        // iterating the days to find desired day which is equal to 23
//        for (int i = 0; i < count; i++) {
//            //We are getting the each day
//            String text = daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).getText();
//
//            //comparing the day number with desired one. when it match the 23,
//            // it will execute and will break the loop.
//            //Select date FROM and click.
//            if (text.equals(dateFrom)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("Start date {} is selected.",dateFrom);
//            }
//            //Select date UNTIL and click.
//            if (text.equals(dateUntil)) {
//                daysTable1.findElements(By.xpath("//div[@class='CalendarDay_content CalendarDay_content__hover_as_highlight_color']")).get(i).click();
//                logger.info("End date {} is selected.", dateUntil);
//                break;
//            }
//        }
    }

    public void endDateAndTime(String date, String time) {

    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("User clicked search button.");
    }
}
