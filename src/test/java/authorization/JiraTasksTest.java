package authorization;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JiraTasksTest {
    private static final String USERNAME = "suhinina";
    private static final String PASSWORD = "Qwerty123";
    private static final String AUTH_COOKIE_KEY = "JSESSIONID";
    private static final String BASE_URI = "https://edujira.ifellow.ru";
    private static final String EXPECTED_HEADER_LOGIN_SUCCESS = "OK";

    @Test
    public void authorizationWithSession() {
        String base64Login = Base64.encodeBase64String((USERNAME + ":" + PASSWORD).getBytes());
        String authorizationHeaderValue = "Basic " + base64Login;

        ExtractableResponse<Response> response = given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .header("Authorization", authorizationHeaderValue)
                .when()
                    .post("/login.jsp")
                .then()
                    .extract();

        assertEquals(EXPECTED_HEADER_LOGIN_SUCCESS, response.header("x-seraph-loginreason"), "Не авторизовались");
        String cookieAuthValue = response.cookie(AUTH_COOKIE_KEY);

        List<Task> tasks = given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .cookie(AUTH_COOKIE_KEY, cookieAuthValue)
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
