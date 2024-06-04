package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(css = "a[href='https://github.com/']")
    private WebElement catIconLink;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath = "//p[contains(text(),'By creating an account')]")
    private WebElement infoText;

    @FindBy(css = "#email-err")
    private WebElement emailErrorContainer;

    @FindBy(css = ".password-validity-summary")
    private WebElement passwordErrorContainer;

    @FindBy(css = "#login-err")
    private WebElement usernameErrorContainer;

    @FindBy(css = ".js-continue-container")
    private WebElement signUpContainer;

    @FindBy(css = ".js-signup-typed-welcome")
    private WebElement welcomeMessage;

    @FindBy(css = "[for='email']")
    private WebElement enterEmailText;

    @FindBy(css = "#email")
    private WebElement emailInput;

    @FindBy(css = "[data-continue-to='password-container']")
    private WebElement contToPassButton;

    @FindBy(css = "[for='password']")
    private WebElement enterPassText;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "[data-continue-to='username-container']")
    private WebElement contToUserButton;

    @FindBy(css = ".octicon-eye")
    private WebElement showPassEyeButton;

    @FindBy(css = "[for='login']")
    private WebElement enterUserText;

    @FindBy(css = "#login")
    private WebElement usernameInput;

    @FindBy(css = "[data-continue-to='opt-in-container']")
    private WebElement contPreferButton;

    @FindBy(xpath = "//label[contains(text(),'Email preferences')]")
    private WebElement preferText;

    @FindBy(xpath = "//label[contains(text(),'Receive')]")
    private WebElement preferInfo;

    @FindBy(css = "#opt_in")
    private WebElement checkbox;

    @FindBy(css = "[data-continue-to='captcha-and-submit-container']")
    private WebElement submitSignUpButton;


    @Step("Visibility of 'Sign Up' page element")
    public Boolean signUpElementVisible() {
        try {
            waitForElementToBeVisible(signUpContainer);
            return signUpContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Set fail email")
    public void setFailEmail(String email) {
        waitForElementToBeVisible(emailInput);
        emailInput.click();
        emailInput.sendKeys(email);
    }

    @Step("Set valid email")
    public void setValidEmail(String email) {
        waitForElementToBeVisible(emailInput);
        emailInput.click();
        emailInput.sendKeys(email);
        waitForElementToBeClickable(contToPassButton);
        contToPassButton.click();
    }

    @Step("Set fail password")
    public void setFailPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    @Step("Set valid password")
    public void setValidPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        waitForElementToBeClickable(contToUserButton);
        contToUserButton.click();
    }

    @Step("Set fail username")
    public void setFailUsername(String username) {
        usernameInput.click();
        usernameInput.sendKeys(username);
    }

    @Step("Set valid username")
    public void setValidUsername(String username) {
        usernameInput.click();
        usernameInput.sendKeys(username);
        waitForElementToBeClickable(contPreferButton);
        contPreferButton.click();
    }

    @Step("Select and check checkbox")
    public Boolean checkCheckbox() {
        waitForElementToBeVisible(checkbox);
        checkbox.click();
        try {
            return checkbox.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click submit sign up button")
    public void clickSubmitSignUp() throws InterruptedException {
        Thread.sleep(5000);
        submitSignUpButton.click();
    }

    @Step("Go to verification page")
    public VerifPage goToVerifPage(String email, String password, String username) throws InterruptedException {
        setValidEmail(email);
        setValidPassword(password);
        setValidUsername(username);
        clickSubmitSignUp();
        Thread.sleep(5000);
        return new VerifPage();
    }

    @Step("Get email error message")
    public String getEmailErrorMessage() {
        waitForElementToBeVisible(emailErrorContainer);
        return emailErrorContainer.getText();
    }

    @Step("Get email password message")
    public String getPasswordErrorMessage() {
        waitForElementToBeVisible(passwordErrorContainer);
        return passwordErrorContainer.getText();
    }

    @Step("Get email username message")
    public String getUsernameErrorMessage() {
        waitForElementToBeVisible(usernameErrorContainer);
        return usernameErrorContainer.getText();
    }

}
