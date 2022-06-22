package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pageobjects.ForgotPasswordPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Browser.getCurrentDriver;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();

    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @AfterAll
    public void closeWindowAfterTest() {
        getCurrentDriver().quit();
    }

    @Test
    public void testSignIn() {

        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.sendKeysToEmailInput("email@ifba.com.br");
        loginPage.sendKeysToPasswordInput("12345");

        loginPage.clickSubmitBtn();
        assertTrue(getCurrentDriver().getCurrentUrl().contains("/index.php?controller=my-account"));
    }

    @Test
    public void testLoginWithInvalidUser() {
        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.sendKeysToEmailInput("wrongUser");
        loginPage.sendKeysToPasswordInput("12345");

        loginPage.clickSubmitBtn();
        assertTrue(loginPage.isElementExisting(loginPage.errorLabel));
        assertTrue(loginPage.errorLabelHasMessage("Invalid email address."));

    }

    @Test
    public void testLoginWithInvalidPass() {
        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.sendKeysToEmailInput("email@ifba.com.br");
        loginPage.sendKeysToPasswordInput("wrongPass");
        loginPage.clickSubmitBtn();

        assertTrue(loginPage.isElementExisting(loginPage.errorLabel));
        assertTrue(loginPage.errorLabelHasMessage("Authentication failed."));

    }

    @Test
    public void testForgotPass() {
        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.clickLostPasswordBtn();
        assertTrue(getCurrentUrl().contains("index.php?controller=password"));

        forgotPasswordPage.sendKeysToEmailInput("email@ifba.com.br");
        forgotPasswordPage.clickRetrievePasswordBtn();

        assertTrue(getCurrentUrl().contains("http://automationpractice.com/index.php?controller=password"));
        assertTrue(forgotPasswordPage.messageLabelHasMessage("A confirmation email has been sent to your address:"));
    }

    @Test
    public void shouldBePasswordInputInvalid() {
        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.sendKeysToEmailInput("email@ifba.com.br");
        loginPage.sendKeysToPasswordInput("");

        loginPage.clickSubmitBtn();

        assertTrue(loginPage.isElementExisting(loginPage.errorLabel));
        assertTrue(loginPage.errorLabelHasMessage("Password is required."));
    }

    @Test
    public void shouldBeEmailInputInvalid() {
        homePage.clickmenuLogin();
        assertTrue(getCurrentUrl().contains("index.php?controller=authentication&back=my-account"));

        loginPage.sendKeysToEmailInput("");
        loginPage.sendKeysToPasswordInput("12345");

        loginPage.clickSubmitBtn();

        assertTrue(loginPage.isElementExisting(loginPage.errorLabel));
        assertTrue(loginPage.errorLabelHasMessage("An email address required."));
    }
}
