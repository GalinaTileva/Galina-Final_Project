package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(css = "a[href='https://github.com/']")
    private WebElement catIconLink;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath = "//p[contains(text(),'By creating an account')]")
    private WebElement infoText;

    @FindBy(css = ".js-continue-hint-container")
    private WebElement hintMessageContainer;

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
    private WebElement contLoginButton;


    public Boolean signUpElementVisible() {
        try {
            waitForElementToBeVisible(signUpContainer);
            return signUpContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
