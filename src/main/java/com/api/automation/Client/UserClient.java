package com.api.automation.Client;

import com.api.automation.utils.RequestSpecUtil;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response getUserById(int userId)
    {
        return given().spec(RequestSpecUtil.getRequestSpec()).when().get("/users/" + userId);
    }
}
