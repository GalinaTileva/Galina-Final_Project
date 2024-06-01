package org.project.pages.HomePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.pages.BasePage;
import org.project.pages.SignUpPage;

public class Header extends BasePage {

    @FindBy(css = "a[href='https://github.com/']")
    private WebElement catIconLink;

    @FindBy(xpath = "//button[contains(text(),'Product')]")
    private WebElement productsMenu;

    @FindBy(xpath = "//button[contains(text(),'Solutions')]")
    private WebElement solutionsMenu;

    @FindBy(xpath = "//button[contains(text(),'Open Source')]")
    private WebElement openSourceMenu;

    @FindBy(css = "a[href = 'https://github.com/pricing']")
    private WebElement pricingLink;

    @FindBy(css = ".header-search-button")
    private WebElement searchBar;

    @FindBy(css = ".HeaderMenu-link--sign-in")
    private WebElement signInButton;

    @FindBy(css = ".HeaderMenu-link--sign-up")
    private WebElement signUpButton;


    @Step("Click 'Sign Up' button")
    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage();
    }

}
