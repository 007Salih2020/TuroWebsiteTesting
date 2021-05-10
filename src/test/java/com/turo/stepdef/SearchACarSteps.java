package com.turo.stepdef;

import com.turo.pages.SearchACar;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.turo.pages.Base.waitSomeTime;

public class SearchACarSteps {
    Logger logger = LoggerFactory.getLogger(SearchACarSteps.class);
    SearchACar searchACar = new SearchACar();


    @Given("user is on landing page to search")
    public void userIsInLandingPageToSearch() {
//        MyDriver.get().get(ConfigurationReader.getProperty("baseUrl"));

//        MyDriver.get().manage().deleteAllCookies();
//        MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
        String expected = "Turo | The world's largest car sharing marketplace";
        String actual = MyDriver.get().getTitle();
        Assert.assertEquals(expected,actual);

        logger.info("Turo.com website title is {}", actual);
    }


    @Then("User enter {string} in Where text box")
    public void userEnterInWhereTextBox(String location) {
        searchACar.enterLocation(location);
    }

    @Then("User select {string} and {string} under From")
    public void userSelectAndUnderFrom(String dateFrom, String dateUntil) {
        searchACar.startDateAndTime(dateFrom, dateUntil);
    }

    @Then("User select {string} and {string} under Until")
    public void userSelectAndUnderUntil(String date, String time) {
        searchACar.endDateAndTime(date, time);
    }

    @Then("User clicks Search button")
    public void userClicksSearchButton() {
        searchACar.clickSearchButton();
    }








}
