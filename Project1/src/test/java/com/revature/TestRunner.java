package com.revature;


import com.revature.poms.HomePage;
import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/",
        glue = "com.revature.steps",
        plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json" }
)
public class TestRunner {

    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;
    public static HomePage homePage;


    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
