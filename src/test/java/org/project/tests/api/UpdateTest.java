package org.project.tests.api;

import io.qameta.allure.*;
import org.project.utils.api.utils.ApiUtils;
import org.project.utils.api.management.update.PatchRequest;
import org.project.utils.api.management.update.PatchResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class UpdateTest extends ApiTestBase {

    @Epic("Repository Management")
    @Feature("Repository Update")
    @Story("Rename Repository")
    @Severity(SeverityLevel.NORMAL)
    @Description("Successful rename repository.")
    @Test(priority = 2)
    public void renameRepo() {
        PatchRequest patchRequest = new PatchRequest();
        patchRequest.setName("Sega");

         PatchResponse response = given()
                .spec(ApiUtils.jsonHeaderRequestSpec())
                .auth()
                .oauth2(TOKEN)
                .body(patchRequest)
                .when()
                  .basePath("/repos/{owner}/{repo}")
                  .pathParam("owner", "BiraSKartofki")
                  .pathParam("repo", "Utre")
                .patch()
                .then()
                .statusCode(200)
                .extract().as(PatchResponse.class);

         assertEquals("Sega", response.getName());
         assertNotNull(response.getUpdatedAt());
         assertTrue(response.isHasProjects());
    }
}
