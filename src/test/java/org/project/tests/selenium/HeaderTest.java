package org.project.tests.selenium;
import io.qameta.allure.*;
import org.project.pages.HomePage.Header;
import org.project.pages.SignUpPage;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class HeaderTest extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;

    @Epic("User Management")
    @Feature("Navigate To Registration Form")
    @Story("Opening Registration Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void goToSignUpPage(){
        header = new Header();
        signUpPage = header.clickSignUpButton();

        assertTrue("Sign up container is not visible on the sign up page", signUpPage.signUpElementVisible());
    }



}
