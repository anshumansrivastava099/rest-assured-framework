package com.api.tests;

import com.api.pojo.UserResponse;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserPojoTest {

    @Test
    public void validateUserUsingPojo()
    {
        Response response = RestAssured.given().baseUri("https://jsonplaceholder.typicode.com").when().get("/users/1");

        UserResponse userResponse = response.as(UserResponse.class);

        Assert.assertEquals(userResponse.getId(),1);
        Assert.assertNotNull(userResponse.getName());
        Assert.assertTrue(userResponse.getEmail().contains("@"));

        Assert.assertNotNull(userResponse.getAddress().getCity());
        Assert.assertNotNull(userResponse.getAddress().getStreet());


    }
}
