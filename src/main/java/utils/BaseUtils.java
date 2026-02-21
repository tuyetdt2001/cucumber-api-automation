package utils;

import io.restassured.RestAssured;

public class BaseUtils {

    static {
        RestAssured.baseURI = "https://reqres.in";
    }
}