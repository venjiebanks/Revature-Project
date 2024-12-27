package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemovePlanetsMoonsSteps {

    @And("the user provides valid planet name to be deleted")
    public void whenUserProvidesValidPlanetNameToBeDeleted() {
        TestRunner.homePage.enterCelestialNameToBeDeleted("Mars");
        TestRunner.homePage.submitDelete();
    }

    @And("the user provides valid moon name to be deleted")
    public void whenUserProvidesValidMoonNameToBeDeleted() {
        TestRunner.homePage.enterCelestialNameToBeDeleted("Luna");
        TestRunner.homePage.submitDelete();
    }

    @And("the user provides invalid {string} to be deleted")
    public void whenUserProvidesInvalidPlanetName(String planetName) {
        TestRunner.homePage.enterCelestialNameToBeDeleted(planetName);
        TestRunner.homePage.submitDelete();
    }


    @Then("the user should see the updated table")
    public void thenUserShouldSeeUpdatedTable() {

        WebElement table = TestRunner.homePage.getTableElement();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() < 4);

    }



}
