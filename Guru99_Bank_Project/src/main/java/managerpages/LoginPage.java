package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userIDInput = By.xpath("//input[@name='uid']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By submitBtn = By.xpath("//input[@name='btnLogin']");
    private By changePasswordLink = By.linkText("Change Password");
    private By addNewCustomerLink = By.linkText("New Customer");
    private By addNewAccLink = By.linkText("New Account");
    private By withdrawalLink = By.linkText("Withdrawal");

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public void enterUserData(String userId , String password){
        driver.findElement(userIDInput).sendKeys(userId);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public welcomePage clickSubmitButton(){
        driver.findElement(submitBtn).click();
        return new welcomePage(driver);
    }

    public String getAlertText() {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public ChangePasswordPage clickChangePasswordLink() {
        driver.findElement(changePasswordLink).click();
        return new ChangePasswordPage(driver);
    }

    public AddNewCustomerPage clickAddNewCustomerLink() {
        driver.findElement(addNewCustomerLink).click();
        return new AddNewCustomerPage(driver);
    }

    public AddNewAccountPage clickAddNewAccLink() {
        driver.findElement(addNewAccLink).click();
        return new AddNewAccountPage(driver);
    }

    public WithdrawalPage clickWithdrawalLink() {
        driver.findElement(withdrawalLink).click();
        return new WithdrawalPage(driver);
    }
}
