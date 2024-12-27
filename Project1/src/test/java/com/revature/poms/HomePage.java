package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(id = "locationSelect")
    WebElement locationSelectDropdown;

    @FindBy(id = "inputContainer")
    WebElement inputContainer;

    @FindBy(id = "planetNameInput")
    WebElement planetNameInputField;

    @FindBy(id = "planetImageInput")
    WebElement planetImageInputField;

    @FindBy(css = ".submit-button")
    WebElement submitPlanetButton;

    @FindBy(id = "moonNameInput")
    WebElement moonNameInputField;

    @FindBy(id = "orbitedPlanetInput")
    WebElement orbitedPlanetInputField;

    @FindBy(id = "moonImageInput")
    WebElement moonImageInputField;

    @FindBy(css = ".submit-button")
    WebElement submitMoonButton;

    @FindBy(id = "celestialTable")
    WebElement celestialTable;

    @FindBy(id = "deleteInput")
    WebElement deleteInputField;

    @FindBy(id = "deleteButton")
    WebElement submitDeleteButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }


    public void selectLocation(String location) {
        Select select = new Select(locationSelectDropdown);
        select.selectByVisibleText(location);
    }

    public void enterPlanetData(String planetName, String fileType) {
        planetNameInputField.sendKeys(planetName);
        planetImageInputField.sendKeys(fileType);
    }

    public void submitPlanet() {
        submitPlanetButton.click();
    }

    public void enterMoonData(String moonName, String planetID, String fileType) {
        moonNameInputField.sendKeys(moonName);
        orbitedPlanetInputField.sendKeys(planetID);
        moonImageInputField.sendKeys(fileType);
    }

    public void submitMoon() {
        submitMoonButton.click();
    }

    public WebElement getTableElement() {
        return celestialTable;
    }

    public void enterCelestialNameToBeDeleted(String celestialName) {
        deleteInputField.sendKeys(celestialName);
    }

    public void submitDelete() {
        submitDeleteButton.click();
    }


}
