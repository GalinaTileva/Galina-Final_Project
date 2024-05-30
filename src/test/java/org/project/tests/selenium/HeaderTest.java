package org.project.tests.selenium;

import org.project.pages.Header;
import org.project.pages.SignUpPage;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class HeaderTest extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;

    @Test
    public void goToSignUpPage(){
        header = new Header();
        header.clickSignUp();
        signUpPage = new SignUpPage();

        assertTrue("Sign up container is not visible on the sign up page", signUpPage.signUpElementVisible());
    }

}
