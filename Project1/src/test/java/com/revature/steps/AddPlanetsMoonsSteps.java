package com.revature.steps;

import com.revature.TestRunner;
import com.revature.poms.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddPlanetsMoonsSteps {


    @When("the user clicks and selects Planet")
    public void whenUserClicksCreatePlanet() {
        TestRunner.homePage.selectLocation("Planet");
    }

    @When("the user clicks and selects Moon")
    public void whenUserClicksCreateMoon() {
        TestRunner.homePage.selectLocation("Moon");
    }

    @And("the user provides valid planet data")
    public void whenUserProvidesValidPlanetData() {
        TestRunner.homePage.enterPlanetData("Krypton", "C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\planet-5.jpg");
        TestRunner.homePage.submitPlanet();
    }

    @And("the user provides valid moon data")
    public void whenUserProvidesValidMoonData() {
        TestRunner.homePage.enterMoonData("Zod", "2","C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\moon-5.jpg");
        TestRunner.homePage.submitMoon();
    }

    @Then("the user should see the updated table with the new Planet")
    public void thenUserShouldSeeUpdatedTablePlanet() {

        WebElement table = TestRunner.homePage.getTableElement();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() > 4);

    }

    @Then("the user should see the updated table with the new Moon")
    public void thenUserShouldSeeUpdatedTableMoon() {

        WebElement table = TestRunner.homePage.getTableElement();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() > 4);

    }

    @When("the user provides an invalid planet name {string} or file type {string}")
    public void whenUserProvidesInvalidPlanetData(String planetName, String fileType) {
        if (!fileType.isEmpty()) {
            // If file type is provided, use it to construct invalid path
            String invalidImagePath = "C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\planet-5" + fileType;
            TestRunner.homePage.enterPlanetData(planetName, invalidImagePath);
        } else {
            // If only invalid planet name is provided
            TestRunner.homePage.enterPlanetData(planetName, "C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\planet-5.jpg");
        }
        TestRunner.homePage.submitPlanet();
    }

    @When("the user provides an invalid moon name {string} or owning planet {string}")
    public void whenUserProvidesInvalidMoonData(String moonName, String planetId) {
        if (planetId != null) {
            // If planet ID is provided, use it (assuming it's an invalid format)
            TestRunner.homePage.enterMoonData(moonName, planetId, "C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\moon-5.jpg");
        } else {
            // If only invalid moon name is provided
            TestRunner.homePage.enterMoonData(moonName, "2", "C:\\Users\\esvba\\Desktop\\Revature\\Revature-Project\\Project1\\src\\test\\resources\\Celestial-Images\\moon-5.jpg");
        }
        TestRunner.homePage.submitMoon();
    }

    @Then("the user should get a planetarium alert saying {string}")
    public void thenUserShouldGetPlanetariumAlert(String expectedAlert) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String actualAlert = alert.getText();
        assertEquals(expectedAlert, actualAlert);
        alert.accept();
    }

    @Then("the user should stay on the home page")
    public void thenUserShouldStayOnHomePage() {
        // Retrieve the current URL
        String currentUrl = TestRunner.driver.getCurrentUrl();
        // Assert that the current URL matches the login page URL
        assertEquals("http://localhost:8080/planetarium", currentUrl);
    }

}
