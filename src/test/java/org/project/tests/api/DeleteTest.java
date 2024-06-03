package org.project.tests.api;

import io.restassured.response.Response;
import org.project.utils.api.create.reporequest.RepoRequest;
import org.project.utils.api.delete.DeleteRequest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class DeleteTest extends ApiTestBase {

    @Test(description = "Delete specific repository if exists", priority = 3)
    public void deleteRepo() {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setRepoNameDelete("Sega");
        deleteRequest.setUsername("BiraSKartofki");

        Response response = given()
                .auth()
                .oauth2(TOKEN)
                .basePath("/repos/{owner}/{repo}")
                .pathParam("owner", deleteRequest.getUsername())
                .pathParam("repo", deleteRequest.getRepoNameDelete())
                .when()
                .get();

        if (response.statusCode() == 200) {
            given()
                    .auth()
                    .oauth2(TOKEN)
                    .basePath("/repos/{owner}/{repo}")
                    .pathParam("owner", deleteRequest.getUsername())
                    .pathParam("repo", deleteRequest.getRepoNameDelete())
                    .when()
                    .delete()
                    .then()
                    .statusCode(204);
        } else {
            System.out.println("Repository does not exist or cannot be accessed.");
        }
    }

    @Test(description = "Check repository is deleted", priority = 4)
    public void checkIfDeleted() {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setRepoNameDelete("Sega");
        deleteRequest.setUsername("BiraSKartofki");

        given()
                .auth()
                .oauth2(TOKEN)
                .basePath("/repos/{owner}/{repo}")
                .pathParam("owner", deleteRequest.getUsername())
                .pathParam("repo", deleteRequest.getRepoNameDelete())
                .when()
                .get()
                .then()
                .statusCode(404);

    }
}
