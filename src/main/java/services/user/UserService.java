package services.user;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserService {

    static {
        baseURI = "https://reqres.in";
    }

    public Response getUser(int userId) {
        return given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .when()
            .get("/api/users/" + userId)
            .then()
            .extract()
            .response();
    }

    public Response getAllUsers() {
        return given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .when()
            .get("/api/users?page=2")
            .then()
            .extract()
            .response();
    }

    public Response createUser(String body) {
        return given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .body(body)
            .when()
            .post("/api/users")
            .then()
            .extract()
            .response();
    }
}