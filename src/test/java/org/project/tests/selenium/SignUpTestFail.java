package org.project.tests.selenium;
import com.opencsv.exceptions.CsvException;
import org.project.csv.CsvReader;
import org.project.pages.HomePage.Header;
import org.project.pages.SignUpPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;


public class SignUpTestFail extends SelenBaseTest {
    private SignUpPage signUpPage;
    private Header header;


    @DataProvider(name = "negative-email-data")
    public static Object[][] emailDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/negativelogin/negative-email-data.csv");
    }

    @Test(dataProvider = "negative-email-data")
    public void testFailEmail(String email, String emailErrorMessage) {
        SoftAssert soft = new SoftAssert();
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setFailEmail(email);
        soft.assertEquals(emailErrorMessage, signUpPage.getEmailErrorMessage());
        soft.assertAll();
    }


    @DataProvider(name = "negative-password-data")
    public static Object[][] passwordDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/negativelogin/negative-password-data.csv");
    }

    @Test(dataProvider = "negative-password-data")
    public void testFailPassword(String password, String passwordErrorMessage) {
        SoftAssert soft = new SoftAssert();
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setValidEmail("canot94906@jahsec.com");
        signUpPage.setFailPassword(password);
        soft.assertEquals(passwordErrorMessage, signUpPage.getPasswordErrorMessage());
        soft.assertAll();
    }

    @DataProvider(name = "negative-username-data")
    public static Object[][] usernameDataCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/negativelogin/negative-username-data.csv");
    }

    @Test(dataProvider = "negative-username-data")
    public void testFailUsername(String username, String userErrorMessage) {
        SoftAssert soft = new SoftAssert();
        header = new Header();
        signUpPage = header.clickSignUpButton();
        signUpPage.setValidEmail("canot94906@jahsec.com");
        signUpPage.setValidPassword("GreenAlien88");
        signUpPage.setFailUsername(username);
        soft.assertEquals(userErrorMessage, signUpPage.getUsernameErrorMessage());
        soft.assertAll();
    }


}
