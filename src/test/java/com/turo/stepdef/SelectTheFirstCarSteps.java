package com.turo.stepdef;

import com.turo.pages.AdvancedSearch;
import com.turo.pages.SearchACar;
import com.turo.pages.SelectTheFirstCar;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.turo.pages.Base.waitSomeTime;

public class SelectTheFirstCarSteps {
    Logger logger = LoggerFactory.getLogger(SelectTheFirstCarSteps.class);
    SelectTheFirstCar selectTheFirstCar = new SelectTheFirstCar();
    SearchACar searchACar = new SearchACar();

    @Given("user is on landing page to select")
    public void userIsOnLandingPageToSelect() {
        MyDriver.get().get(ConfigurationReader.getProperty("selectTheFirstCarUrl"));

//        MyDriver.get().manage().deleteAllCookies();
//        MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
    }

    @Then("User selects the first car in the list and verify the selected car title is present")
    public void userSelectsTheFirstCarInTheListAndVerifyTheSelectedCarTitleIsPresent() {
        selectTheFirstCar.selectTheFirstCarAndVerify();
    }

    @Then("User selects Pickup location")
    public void userSelectsPickupReturnLocation() {
        selectTheFirstCar.selectPickupLocation();
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        selectTheFirstCar.clickOnContinue();
    }
}
