package org.project.tests.api;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.project.utils.api.management.delete.DeleteRequest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteTest extends ApiTestBase {

    @Epic("Repository Management")
    @Feature("Repository Delete")
    @Story("Delete repository.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete specific repository if exists.")
    @Test(priority = 3)
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

    @Epic("Repository Management")
    @Feature("Repository Delete")
    @Story("Verify specific repository does not exist.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check specific repository does not exist.")
    @Test(priority = 4)
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
