package authorization;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class Jira {

    @Test
    public void authorizationWithSession() {
        ExtractableResponse<Response> responseFirst = given()
                    .baseUri("https://edujira.ifellow.ru")
                .when()
                    .get("login.jsp")
                .then()
                    .log()
                    .all()
                    .extract();
        String cookie = responseFirst.cookie("JSESSIONID");
        System.out.println(cookie);

        JSONObject loginBody = new JSONObject().put("username", "suhinina")
                .put("password", "Qwerty123");

        String cookieAuth = given()
                .baseUri("https://edujira.ifellow.ru")
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic c3VoaW5pbmE6UXdlcnR5MTIz")
//                .body(loginBody.toString())
                .when()
                    .post("/login.jsp")
                .then()
                .extract()
                .cookie("JSESSIONID");


        List<Task> tasks = given()
                    .baseUri("https://edujira.ifellow.ru")
                    .contentType(ContentType.JSON)
                    .cookie("JSESSIONID", cookieAuth)
                .when()
                    .get("rest/greenhopper/1.0/xboard/plan/backlog/data.json?rapidViewId=1")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("issues", Task.class);
        System.out.println(tasks);
    }
}
