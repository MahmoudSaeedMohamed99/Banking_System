package managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class welcomePage {

    private WebDriver driver;
    private By managerIdHeader = By.xpath("//tr[@class='heading3']/td");

    public welcomePage(WebDriver driver){ this.driver = driver; }

    public String getManagerIdText(){
        return driver.findElement(managerIdHeader).getText();
    }
    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }

}
