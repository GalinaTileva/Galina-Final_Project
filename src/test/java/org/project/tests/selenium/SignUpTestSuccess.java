package org.project.tests.selenium;

import com.opencsv.exceptions.CsvException;
import org.project.utils.selenium.CsvReader;
import org.project.pages.Header;
import org.project.pages.SignUpPage;
import org.project.pages.VerifPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class SignUpTestSuccess extends SelenBaseTest {
    private Header header;
    private SignUpPage signUpPage;
    private VerifPage verifPage;


    @DataProvider(name = "positive-login-data")
    public static Object[][] positiveLoginDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/positivelogin/positive-login-data.csv");
    }

    @Test(dataProvider = "positive-login-data")
    public void checkboxSelected(String email, String password, String username) {
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setValidEmail(email);
        signUpPage.setValidPassword(password);
        signUpPage.setValidUsername(username);

        assertTrue(signUpPage.checkCheckbox(), "Checkbox is not selected");
    }

    @Test(dataProvider = "positive-login-data")
    public void positiveLogin(String email, String password, String username) throws InterruptedException {
        header = new Header();
        signUpPage = header.clickSignUpButton();
        verifPage = signUpPage.goToVerifPage("canot94906@jahsec.com","GreenAlien88",
                "ImOnAVacation");



        assertTrue(verifPage.verifyPageElementDisplayed(), "Verify page element is not displayed");
    }





}
