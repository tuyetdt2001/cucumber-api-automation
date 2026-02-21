package stepdefinitions.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;

import services.user.UserService;

import static org.junit.Assert.assertEquals;

public class UserSteps {

    private Response response;
    private UserService userService = new UserService();
    private String requestBody;

    // ==============================
    // GET USER BY ID
    // ==============================

    @When("I call GET user API with id {int}")
    public void callGetUser(int userId) {
        response = userService.getUser(userId);
        System.out.println("Response Body: " + response.asString());
    }

    // ==============================
    // GET ALL USERS
    // ==============================

    @When("I call GET all users API")
    public void callGetAllUsers() {
        response = userService.getAllUsers();
        System.out.println("Response Body: " + response.asString());
    }

    // ==============================
    // CREATE USER
    // ==============================

    @Given("a valid user information")
    public void a_valid_user_information() {
        requestBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
    }

    @When("user sends create user request")
    public void user_sends_create_user_request() {
        response = userService.createUser(requestBody);
        System.out.println("Response Body: " + response.asString());
    }

    // ==============================
    // VERIFY STATUS CODE
    // ==============================

    @Then("Response status should be {int}")
    public void verifyStatus(int expectedStatus) {
        int actualStatus = response.getStatusCode();
        System.out.println("Actual Status Code: " + actualStatus);
        assertEquals(expectedStatus, actualStatus);
    }

    @Then("response status should be {int}")
    public void verifyStatusLowerCase(int expectedStatus) {
        int actualStatus = response.getStatusCode();
        System.out.println("Actual Status Code: " + actualStatus);
        assertEquals(expectedStatus, actualStatus);
    }
}