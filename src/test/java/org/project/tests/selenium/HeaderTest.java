package org.project.tests.selenium;

import io.qameta.allure.*;
import org.project.pages.Header;
import org.project.pages.SignUpPage;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class HeaderTest extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;

    @Epic("User Management")
    @Feature("User Navigation")
    @Story("Navigation from home to sign up page for new registration.")
    @Severity(SeverityLevel.NORMAL)
    @Description("User can navigate from home to sign up page and is redirected to sign up form.")
    @Test
    public void goToSignUpPage(){
        header = new Header();
        signUpPage = header.clickSignUpButton();

        assertTrue("Sign up container is not visible on the sign up page", signUpPage.signUpElementVisible());
    }

}