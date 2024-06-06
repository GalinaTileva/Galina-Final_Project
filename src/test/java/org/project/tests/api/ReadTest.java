package org.project.tests.api;

import io.qameta.allure.*;
import org.project.utils.api.management.read.readresponse.ReadResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

public class ReadTest extends ApiTestBase {

    @Epic("Repository Management")
    @Feature("Repository Retrieval.")
    @Story("User can access repository details.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Getting repository details.")
    @Test
    public void readRepo() {
        SoftAssert soft = new SoftAssert();

        ReadResponse response = given()
                .basePath("/repos/{owner}/{repo}")
                .pathParam("owner", "BiraSKartofki")
                .pathParam("repo", "Utre")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(ReadResponse.class);


        soft.assertNotNull(response.getId());
        soft.assertNotNull(response.getNodeId());
        soft.assertFalse(response.isPrivateRepo());
        soft.assertEquals(response.getOwner().getId(), 171449312);
        soft.assertEquals(response.getOwner().getNodeId(), "U_kgDOCjgb4A");
        soft.assertEquals(response.getOwner().getGravatarId(), "");
        soft.assertFalse(response.getOwner().isSiteAdmin());
        soft.assertAll();
    }

}
