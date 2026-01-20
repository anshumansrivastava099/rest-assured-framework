package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePostTests {

    @Test
    public void createUser()
    {

        String payload =
         """
         {
             "title": "API Automation",
              "body": "Rest Assured Learning",
              "userId": 1
          }
           """;


        Response response = RestAssured.given().baseUri("https://jsonplaceholder.typicode.com").header("Content-Type", "application/json")
                .body(payload).
                when().
                post("/posts");

        Assert.assertEquals(response.getStatusCode(),201);

        Assert.assertEquals(response.jsonPath().getString("title"),"API Automation");
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
    }
}


//JsonPath is used for quick validations, POJO is preferred for large structured responses.
