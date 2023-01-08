package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalPage {

    private WebDriver driver;
    private By accNumField = By.xpath("//input[@name='accountno']");
    private By amountField = By.xpath("//input[@name='ammount']");
    private By descField = By.xpath("//input[@name='desc']");
    private By submitBtn = By.xpath("//input[@name='AccSubmit']");
    private By accNumber = By.xpath("//table[@name='withdraw']//tr/td/p");

    public WithdrawalPage(WebDriver driver) { this.driver = driver; }

    public void enterWithdrawalData(String accNum, String amount, String desc) {
        driver.findElement(accNumField).sendKeys(accNum);
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(descField).sendKeys(desc);
        driver.findElement(submitBtn).click();
    }

    public String getAccNumber() {
        return driver.findElement(accNumber).getText();
    }
}
