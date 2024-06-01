package org.project.tests.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifPageTest extends SelenBaseTest {

    @FindBy(xpath = "//div[contains(text(), 'Verify')]")
    private WebElement verifText;

    @FindBy(xpath = "//h2[contains(text(),'Protecting')]")
    private WebElement protectText;

    @FindBy(xpath = "//p[contains(text(),'puzzle')]")
    private WebElement puzzleText;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    private WebElement verifyButton;

    @FindBy(xpath = "//p[contains(text(),'Audio')]")
    private WebElement audioButton;

}
