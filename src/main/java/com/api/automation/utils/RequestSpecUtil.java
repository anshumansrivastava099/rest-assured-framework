package com.api.automation.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecUtil {

    public static RequestSpecification getRequestSpec()
    {
        return new RequestSpecBuilder().
                setBaseUri(ConfigReader.get("base.url")).
                setContentType(ContentType.JSON).
                build();
    }
}
