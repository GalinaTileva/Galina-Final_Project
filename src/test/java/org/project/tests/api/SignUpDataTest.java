package org.project.tests.api;

import com.opencsv.exceptions.CsvException;
import io.restassured.RestAssured;
import org.project.csv.CsvReader;
import org.project.utils.api.signup.SignUpRequest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignUpDataTest extends ApiTestBase {
    private SignUpRequest signUpRequest;


    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        RestAssured.basePath = "/signup";
    }



    @DataProvider(name = "negative-email-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/csv/negativelogin/negative-email-data.csv");
    }
    @Test(dataProvider = "negative-email-data")
    public void failEmail() {
       // SignUpRequest request = new SignUpRequest();

    }



    @Test
    public void failPassword(){}



    @Test
    public void failUsername(){}







    


}
