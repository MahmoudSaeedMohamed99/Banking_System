package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage {

    private WebDriver driver;
    private By customerIdField = By.xpath("//input[@name='cusid']");
    private By accountTypeSelectBox = By.xpath("//select[@name='selaccount']");
    private By initialDepositField = By.xpath("//input[@name='inideposit']");
    private By submitBtn = By.xpath("//input[@name='button2']");
    private By customerId = By.xpath("//table[@id='account']//tr[5]/td[2]");

    public AddNewAccountPage(WebDriver driver) { this.driver = driver; }

    public void enterNewAccData(String cusId, String accType, String iniDeposit) {
        Select accTypeSelectBox = new Select(driver.findElement(accountTypeSelectBox));
        driver.findElement(customerIdField).sendKeys(cusId);
        accTypeSelectBox.selectByVisibleText(accType);
        driver.findElement(initialDepositField).sendKeys(iniDeposit);
        driver.findElement(submitBtn).click();
    }

    public String getCustomerId() {
        return driver.findElement(customerId).getText();
    }
}
