package com.turo.stepdef;

import com.turo.pages.AdvancedSearch;
import com.turo.pages.SearchACar;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.turo.pages.Base.waitSomeTime;

public class AdvancedSearchSteps {
    Logger logger = LoggerFactory.getLogger(AdvancedSearchSteps.class);
    AdvancedSearch advancedSearch = new AdvancedSearch();
    SearchACar searchACar = new SearchACar();


    @Given("User is on landing page to advanced search")
    public void userIsOnLandingPageToAdvancedSearch() {
        MyDriver.get().get(ConfigurationReader.getProperty("advancedUrl"));

//        MyDriver.get().manage().deleteAllCookies();
//        MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
    }

    @And("User clicks on More filters menu and select All-Star Host")
    public void userClicksOnMoreFiltersMenuAndSelectAllStarHost() {
        advancedSearch.moreFilterOptions();
    }

    @And("select CAR Vehicle types and select {string} then clicks on upper arrow")
    public void selectCARVehicleTypesAndSelectThenClicksOnUpperArrow(String vehicle_makes) {
        advancedSearch.selectCarAndVehicleMakes(vehicle_makes);
    }

    @And("User adjust the Vehicle years range")
    public void userAdjustTheVehicleYearsRange() {
        advancedSearch.adjustYears();

    }

    @Then("User select the Transmission clicks on view results")
    public void userSelectTheTransmissionClicksOnViewResults() {
        advancedSearch.selectTransmission();
    }

    // Start from the Sort By menu
    @And("User clicks on Sort By menu and select an option then clicks on apply")
    public void userClicksOnSortByMenuAndSelectAnOptionThenClicksOnApply() {
        advancedSearch.clickOnSortBy();
    }

    @And("User clicks on Price menu and adjust the price range then clicks on view results")
    public void userClicksOnPriceMenuAndAdjustThePriceRangeThenClicksOnViewResults() {
        advancedSearch.clickOnPrice();
    }

    @And("User clicks on Book instantly menu and clicks on view results")
    public void userClicksOnBookInstantlyMenuAndClicksOnViewResults() {
        advancedSearch.clickOnBookInstant();
    }

    @And("User clicks on Delivery menu and adjust the distance range then clicks on view results")
    public void userClicksOnDeliveryMenuAndAdjustTheDistanceRangeThenClicksOnViewResults() {
        advancedSearch.adjustDeliveryOption();
    }

    @And("User clicks on Distance included menu and select the distance then clicks on  apply button")
    public void userClicksOnDistanceIncludedMenuAndSelectTheDistanceThenClicksOnApplyButton() {
        advancedSearch.distanceIncludedOption();
    }

}
