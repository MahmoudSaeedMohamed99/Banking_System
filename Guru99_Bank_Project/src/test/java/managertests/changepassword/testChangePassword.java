package managertests.changepassword;

import base.BaseTest;
import org.testng.annotations.Test;
import managerpages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class testChangePassword extends BaseTest {
    @Test
    public void testChangePassword() {
        LoginPage loginPage = homePage.getloginPage();
        loginPage.enterUserData("mngr459918" , "ajubyqA");
        var logged = loginPage.clickSubmitButton();
        assertTrue(logged.getManagerIdText().contains("mngr459918") , "Manager ID is incorrect");
        var changePassword = loginPage.clickChangePasswordLink();
        changePassword.sendPasswordData("mmmmmm" , "12345_" , "12345_");
        assertEquals(changePassword.returnAlertMessage() , "Old Password is incorrect" , "Alert Message is incorrect");
    }
}
