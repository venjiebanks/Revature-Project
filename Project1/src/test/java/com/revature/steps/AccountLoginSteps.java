package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class AccountLoginSteps {


    @When("the user provides login username {string} and password {string}")
    public void userProvidesUsernameAndPassword(String username, String password) {
        // Use LoginPage methods to input credentials
        TestRunner.loginPage.enterUsername(username);
        TestRunner.loginPage.enterPassword(password);
    }

    @When("the user submits the login credentials")
    public void userSubmitsLogin() {
        // Use LoginPage method to submit the login form
        TestRunner.loginPage.clickLoginButton();
    }



    @Then("if the credentials are valid, the user should be redirected to the home page")
    public void ifTheCredentialsAreValidTheUserShouldBeRedirectedToTheHomePage() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        String expectedTitle = "Home";
        String actualTitle = TestRunner.driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("if the credentials are invalid, the user should get a browser alert saying {string}")
    public void ifTheCredentialsAreInvalidTheUserShouldGetABrowserAlertSaying(String arg0) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals("Invalid credentials", alert.getText());
        alert.accept();
    }

    @And("the user should stay on the login page")
    public void theUserShouldStayOnTheLoginPage() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }
}
