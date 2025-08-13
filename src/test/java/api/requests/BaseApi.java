package api.requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    private static final String BASE_URL = "https://dummyapi.io/data/v1";

    public RequestSpecification request() {
        return RestAssured.given()
                .baseUri(BASE_URL);
    }
}
