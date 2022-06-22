package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseActionElement;
import utils.Browser;

public class LoginPage extends BaseActionElement {

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(name = "SubmitLogin")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    public WebElement lostPasswordBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    public WebElement errorLabel;

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void sendKeysToEmailInput(String value) {
        emailInput.sendKeys(value);
    }

    public boolean isEmailInputBlank() {
        return emailInput.getText().length() <= 0;
    }

    public void sendKeysToPasswordInput(String value) {
        passwordInput.sendKeys(value);
    }

    public boolean isPasswordInputBlank() {
        return passwordInput.getText().length() <= 0;
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void clickLostPasswordBtn() {
        lostPasswordBtn.click();
    }

    public boolean errorLabelHasMessage(String message) {
        return errorLabel.getText().equals(message);
    }
}
