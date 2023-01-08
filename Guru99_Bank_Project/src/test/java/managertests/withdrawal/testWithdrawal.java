package managertests.withdrawal;

import base.BaseTest;
import org.testng.annotations.Test;
import managerpages.LoginPage;

import static org.testng.Assert.assertTrue;

public class testWithdrawal extends BaseTest {

    @Test
    public void testWithdrawal() {
        LoginPage loginPage = homePage.getloginPage();
        loginPage.enterUserData("mngr459918", "ajubyqA");
        loginPage.clickSubmitButton();
        var withdrawalPage = loginPage.clickWithdrawalLink();
        withdrawalPage.enterWithdrawalData("116761", "2000", "third one");
        assertTrue(withdrawalPage.getAccNumber().contains("116761"), "Account Id is invalid");
    }
}
