package org.project.tests.api;

import io.qameta.allure.*;
import org.project.utils.api.utils.ApiUtils;
import org.project.utils.api.management.create.reporequest.RepoRequest;
import org.project.utils.api.management.create.reporesponse.RepoResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CreateTest extends ApiTestBase {

    @Epic("Repository Management")
    @Feature("Repository Creation")
    @Story("User can create new repository.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Generating a new repository.")
    @Test
    public void createRepo() {
        RepoRequest repoRequest = new RepoRequest();
        repoRequest.setName("Utre");

        RepoResponse response = given()
                .spec(ApiUtils.jsonHeaderRequestSpec())
                .auth()
                .oauth2(TOKEN)
                .body(repoRequest)
                .when()
                .basePath("/user/repos")
                .post()
                .then()
                .statusCode(201)
                .extract().as(RepoResponse.class);

          assertNotNull(response.getCreatedAt());
          assertEquals(response.getMergeCommitMessage(), "PR_TITLE");
          assertEquals(response.getOwner().getType(), "User");
          assertEquals(response.getOwner().getAvatarUrl(),"https://avatars.githubusercontent.com/u/171449312?v=4");
          assertTrue(response.getPermissions().isAdmin());
          assertTrue(response.getPermissions().isPush());
          assertTrue(response.getPermissions().isPull());

    }

}

