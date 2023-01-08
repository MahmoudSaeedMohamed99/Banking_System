package managertests.addnewaccount;

import base.BaseTest;
import org.testng.annotations.Test;
import managerpages.LoginPage;

import static org.testng.Assert.*;

public class testAddNewAccount extends BaseTest {

    @Test
    public void testAddNewAccount() {
        LoginPage loginPage = homePage.getloginPage();
        loginPage.enterUserData("mngr459918", "ajubyqA");
        var welcomePage = loginPage.clickSubmitButton();
        assertTrue(welcomePage.getManagerIdText().contains("mngr459918"),"Invalid Manager Id");
        var addNewAccPage = loginPage.clickAddNewAccLink();
        addNewAccPage.enterNewAccData("11299", "Savings", "100000");
        assertEquals(addNewAccPage.getCustomerId(), "11299", "Customer Id doesn't match");
    }
}
