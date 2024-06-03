package org.project.tests.api;

import org.project.utils.api.ApiUtils;
import org.project.utils.api.create.reporequest.RepoRequest;
import org.project.utils.api.create.reporesponse.RepoResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CreateTest extends ApiTestBase {


    @Test(description = "Create a repository", priority = 0)
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

