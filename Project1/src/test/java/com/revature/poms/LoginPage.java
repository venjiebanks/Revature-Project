package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(tagName = "input")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private WebElement registrationLink;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the login page

    public void openLoginPage() {
        driver.get("http://localhost:8080/");
    }

    public void clickRegisterLink() {
        registrationLink.click();
    }

    // Method to enter username
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        loginButton.submit();
    }

    public void setUpLoggedInUser(){
        driver.get("http://localhost:8080/");
        usernameInput.sendKeys("Batman");
        passwordInput.sendKeys("Iamthenight1939");
        loginButton.submit();
    }



}
