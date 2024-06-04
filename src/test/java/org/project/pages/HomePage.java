package org.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.pages.BasePage;

public class HomePage extends BasePage {

    @FindBy(css = "#universe24_super_early_bird")
    private WebElement announcement;

    //info
}
