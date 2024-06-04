package org.project.tests.api;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeMethod;

public class ApiTestBase {
    static final String TOKEN = "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";

    @BeforeMethod
    public void setUp () {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.config = RestAssuredConfig.config()
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
    }
}
