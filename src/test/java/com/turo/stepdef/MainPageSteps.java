package com.turo.stepdef;

import com.turo.pages.MainPage;
import com.turo.utils.ConfigurationReader;
import com.turo.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.turo.pages.Base.waitSomeTime;


public class MainPageSteps {
    Logger logger = LoggerFactory.getLogger(MainPageSteps.class);
    MainPage mainPage = new MainPage();

    @Given("user is in landing page")
    public void userIsInLandingPage() {
        MyDriver.get().get(ConfigurationReader.getProperty("baseUrl"));

        MyDriver.get().manage().deleteAllCookies();
//        MyDriver.get().navigate().refresh();
        waitSomeTime(5L);
        String expected = "Turo | The world's largest car sharing marketplace";
        String actual = MyDriver.get().getTitle();
        Assert.assertEquals(expected,actual);

        logger.info("Turo.com website title is {}", actual);
    }

    @Then("Verify that Turo logo is present")
    public void verifyThatTuroLogoIsPresent()  {
        mainPage.logo.isDisplayed();
        logger.info("Turo logo is displayed");
    }

    @Then("Verify that {string} is present")
    public void verifyThatIsPresent(String value) {
        mainPage.verifyTheFields(value);
    }

    @Then("Verify that Liberty mutual insurance logo is present")
    public void verifyThatLibertyMutualInsuranceLogoIsPresent() {
        mainPage.verifyInsuranceLogo();
    }
}
