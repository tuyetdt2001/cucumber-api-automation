package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    static {
        RestAssured.baseURI = Config.BASE_URL;
    }

    public static Response post(String endpoint, Object body) {
        return RestAssured
            .given()
            .contentType("application/json")
            .body(body)
            .when()
            .post(endpoint);
    }

    public static Response get(String endpoint) {
        return RestAssured
            .given()
            .when()
            .get(endpoint);
    }

    public static Response delete(String endpoint) {
        return RestAssured
            .given()
            .when()
            .delete(endpoint);
    }
}