package managertests.addnewcustomer;

import base.BaseTest;
import dataprovider.CustomeDataProvider;
import org.testng.annotations.Test;
import managerpages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class AddNewCustomer extends BaseTest {

    @Test(dataProvider = "New Customer Data" , dataProviderClass = CustomeDataProvider.class)
    public void testAddNewCustomer(String custName , String gender, String birthDate, String address, String city, String state, String pin, String number, String mail, String password) {
        LoginPage loginPage = homePage.getloginPage();
        loginPage.enterUserData("mngr459918" , "ajubyqA");
        var managerDashboard = loginPage.clickSubmitButton();
        assertTrue(managerDashboard.getManagerIdText().contains("mngr459918"), "Manager ID is incorrect");
        var newCustomerPage = loginPage.clickAddNewCustomerLink();
        newCustomerPage.sendCustomerData(custName, gender, birthDate, address, city, state, pin, number, mail, password);
        assertEquals(newCustomerPage.successfulMsg(), "Customer Registered Successfully!!!", "Invalid Customer Data");
    }
}
