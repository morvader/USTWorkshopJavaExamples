package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = APIConstants.BASE_URL;
    }

    @Test
    public void testGetUser() {
        given()
                .pathParam("id", 1)
                .when()
                .get(APIConstants.GET_USER_ENDPOINT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo(1))
                .body("data.email", equalTo("george.bluth@reqres.in"))
                .body("data.first_name", equalTo("George"))
                .body("data.last_name", equalTo("Bluth"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"));
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"job\": \"Software Engineer\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(APIConstants.CREATE_USER_ENDPOINT)
                .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("job", equalTo("Software Engineer"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
}

