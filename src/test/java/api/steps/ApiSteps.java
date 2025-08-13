package api.steps;

import api.requests.UserApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiSteps {

    private UserApi userApi = new UserApi();
    private Response response;
    private String createdUserId;

    @Given("I send a request to get user by id {string}")
    public void iSendRequestToGetUserById(String userId) {
        System.out.println("[STEP] Sending GET request for user ID: " + userId);
        response = userApi.getUserById(userId);
    }

    @Given("I create a new user with firstName {string}, lastName {string}, and email {string}")
    public void iCreateANewUser(String firstName, String lastName, String email) {
        if (email == null || email.isEmpty() || email.equalsIgnoreCase("unique")) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + System.currentTimeMillis() + "@example.com";
        }
        response = userApi.createUser(firstName, lastName, email);

        // Simpan ID untuk update/delete selanjutnya
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
            createdUserId = response.jsonPath().getString("id");
            System.out.println("[INFO] Created User ID: " + createdUserId);
        }
    }

    @When("I update the created user firstName to {string}")
    public void iUpdateTheCreatedUser(String newFirstName) {
        Assert.assertNotNull("Created user ID is null, cannot update", createdUserId);
        response = userApi.updateUser(createdUserId, newFirstName);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
