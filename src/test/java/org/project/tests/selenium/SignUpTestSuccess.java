package org.project.tests.selenium;

import com.opencsv.exceptions.CsvException;
import org.project.csv.CsvReader;
import org.project.pages.HomePage.Header;
import org.project.pages.SignUpPage;
import org.project.pages.VerifPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;




public class SignUpTestSuccess extends SelenBaseTest {
    private SignUpPage signUpPage;
    private Header header;

    @DataProvider(name = "positive-login-data")
    public static Object[][] positiveLoginDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/positivelogin/positive-login-data.csv");
    }

    @Test(dataProvider = "positive-login-data")
    public void positiveLogin(String email, String password, String username) {
        SoftAssert soft = new SoftAssert();
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setValidEmail(email);
        signUpPage.setValidPassword(password);
        signUpPage.setValidUsername(username);

        soft.assertTrue(signUpPage.checkCheckbox(), "Checkbox is not selected");
        soft.assertAll();
    }






}
