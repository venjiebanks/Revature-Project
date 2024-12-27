package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountCreationSteps {

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user clicks the register link")
    public void userClicksRegisterLink() {
        TestRunner.loginPage.clickRegisterLink();
    }

    @When("the user provides registration username {string} and password {string}")
    public void userProvidesCredentials(String username, String password) {
        TestRunner.registrationPage.enterUsername(username);
        TestRunner.registrationPage.enterPassword(password);
    }

    @When("the user submits the registration credentials")
    public void userSubmitsRegistration() {
        TestRunner.registrationPage.clickSubmit();
    }

    @Then("the user should get a browser alert saying {string}")
    public void userShouldGetAlert(String expectedAlert) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String actualAlert = alert.getText();
        assertEquals(expectedAlert, actualAlert);
        alert.accept();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Retrieve the current URL
        String currentUrl = TestRunner.driver.getCurrentUrl();
        // Assert that the current URL matches the login page URL
        assertEquals("http://localhost:8080/", currentUrl);
    }

    @Then("the user should stay on the registration page")
    public void the_user_should_stay_on_the_registration_page() {
        // Retrieve the current URL
        String currentUrl = TestRunner.driver.getCurrentUrl();
        // Assert that the current URL matches the login page URL
        assertEquals("http://localhost:8080/register", currentUrl);
    }


}
