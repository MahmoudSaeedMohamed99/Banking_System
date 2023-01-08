package managertests.login;

import base.BaseTest;
import managerpages.LoginPage;
import managerpages.welcomePage;
import dataprovider.ExcelDataProvider;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.NoAlertPresentException;

//Create LoginTest Class which extends from BasrTest Class
public class LoginTestExcelFile extends BaseTest {

    //Create TestLoginData Function which takes Username and Password as parameters
    //Gets the data from the data provider exits in ExcelDataProvider Class
    @Test(dataProvider = "LoginTestData" , dataProviderClass = ExcelDataProvider.class)
    public void testLoginData(String userId , String password) {

        //Initialize LoginPage Object
        LoginPage loginPage = homePage.getloginPage();
        //Send Username and Password to enterUserData Function
        loginPage.enterUserData(userId , password);
        //Return welcomePage from clickSubmitButton Function into welcomePage Object
        welcomePage welcome = loginPage.clickSubmitButton();

        try {
            //Get Alert Text from Alert Box which appears when you enter invalid data
            String alertText = loginPage.getAlertText().trim();
            //Verify that Alert Text is shown with the right message
            assertEquals(alertText , "User or Password is not valid" , "Alert Text is incorrect");

        } catch (NoAlertPresentException e) {
            //Get ManagerID which appears on welcomePage
            String mangerID = welcome.getManagerIdText().trim();
            //Verify that ManagerID is the same userId that has entered
            assertTrue(mangerID.contains(userId) , "Manager Id is incorrect");
        }
    }
}