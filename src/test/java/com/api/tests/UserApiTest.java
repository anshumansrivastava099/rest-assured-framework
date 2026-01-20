package com.api.tests;

import com.api.automation.Client.UserClient;
import com.api.pojo.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    UserClient userClient = new UserClient();


    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user API response")
    @Test
    public void validateUser()
    {
        Response response = userClient.getUserById(1);

        UserResponse userResponse = response.as(UserResponse.class);

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(userResponse.getId(),1);
        Assert.assertNotNull(userResponse.getName());
        Assert.assertNotNull(userResponse.getAddress().getCity());

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user API response")
    @Test
    public void invalidUserId()
    {
        Response response = userClient.getUserById(9999);

        Assert.assertEquals(response.getStatusCode(),404);
    }



    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user API response")
    @Test
    public void getUserNotFound()
    {
        Response response = userClient.getUserById(0);

        Assert.assertEquals(response.getStatusCode(),404);
    }

}
