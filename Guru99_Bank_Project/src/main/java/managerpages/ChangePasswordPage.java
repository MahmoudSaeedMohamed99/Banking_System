package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    private WebDriver driver;
    private By oldPasswordInput = By.xpath("//input[@name='oldpassword']");
    private By newPasswordInput = By.xpath("//input[@name='newpassword']");
    private By confirmPasswordInput = By.xpath("//input[@name='confirmpassword']");
    private By submitBtn = By.xpath("//input[@name='sub']");
    public ChangePasswordPage(WebDriver driver) { this.driver = driver; }

    public void sendPasswordData(String old , String newPass , String confirm) {
        driver.findElement(oldPasswordInput).sendKeys(old);
        driver.findElement(newPasswordInput).sendKeys(newPass);
        driver.findElement(confirmPasswordInput).sendKeys(confirm);
        driver.findElement(submitBtn).click();
    }

    public String returnAlertMessage() {
        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMsg;
    }
}
