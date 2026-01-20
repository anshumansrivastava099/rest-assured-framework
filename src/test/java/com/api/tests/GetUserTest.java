package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getUserDetails()
    {
       Response response =  RestAssured.given().
                baseUri("https://jsonplaceholder.typicode.com").
                log().all().
                when().
                get("/users/1");

       //Status code assertion
        Assert.assertEquals(response.getStatusCode(),200,"Status code mismatch");

        response.prettyPrint();

        Assert.assertEquals(response.jsonPath().getInt("id"),1);
        Assert.assertNotNull(response.jsonPath().getString("name"));
        Assert.assertTrue(response.jsonPath().getString("email").contains("@"));



    }
}


/*
given()  // request setup (headers, params, body)
when()   // HTTP method (GET, POST...)
then()   // assertions (status, response)
log().all() // it is used for the print response

 */
