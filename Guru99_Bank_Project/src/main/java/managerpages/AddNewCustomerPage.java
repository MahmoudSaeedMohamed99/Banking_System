package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewCustomerPage {
    private WebDriver driver;
    private By custNameInput = By.xpath("//input[@name='name']");
    private By maleRadioButton = By.xpath("//input[@value='m']");
    private By femaleRadioButton = By.xpath("//input[@value='f']");
    private By dateOfBirthInput = By.xpath("//input[@name='dob']");
    private By addressArea = By.xpath("//textarea[@name='addr']");
    private By cityInput = By.xpath("//input[@name='city']");
    private By stateInput = By.xpath("//input[@name='state']");
    private By pinInput = By.xpath("//input[@name='pinno']");
    private By phoneInput = By.xpath("//input[@name='telephoneno']");
    private By emailInput = By.xpath("//input[@name='emailid']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By submitBtn = By.xpath("//input[@name='sub']");
    private By successfulMsg = By.xpath("//table[@name='regmsg']//table//p");
    public AddNewCustomerPage(WebDriver driver) { this.driver = driver; }

    public void sendCustomerData(String custName , String gender, String birthDate, String address, String city, String state, String pin, String number, String mail, String password) {
        driver.findElement(custNameInput).sendKeys(custName);
        if (gender == "male") { driver.findElement(maleRadioButton).click(); }
        else if (gender == "female") { driver.findElement(femaleRadioButton).click(); }
        driver.findElement(dateOfBirthInput).sendKeys(birthDate);
        driver.findElement(addressArea).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(pinInput).sendKeys(pin);
        driver.findElement(phoneInput).sendKeys(number);
        driver.findElement(emailInput).sendKeys(mail);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();
    }

    public String successfulMsg() {
        return driver.findElement(successfulMsg).getText();
    }
}
