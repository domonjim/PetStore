package com.petstore.teststeps;

import com.petstore.userendpoints.UserEndpoint;
import com.petstore.userendpoints.payloadsCreateUser.PayloadCreateUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasKey;

public class UserSteps {
    @Step("Create User")
    public String createUser(PayloadCreateUser payloadCreateUser, Integer statusCode){
        Response response = UserEndpoint.createUser(payloadCreateUser);

        switch (statusCode){
            case 200:
                response.then()
                        .statusCode(statusCode)
                        .body("$", hasKey("message"))
                        .log().all();
        }
        return response.jsonPath().get("message").toString();
    }

    @Step("Get User")
    public Response getUser(String userName, Integer statusCode){

        Response response = UserEndpoint.getUser(userName);

        switch (statusCode){
            case 200:
                response.then()
                        .statusCode(statusCode)
                        .body("$", hasKey("id"))
                        .body("$", hasKey("username"))
                        .body("$", hasKey("firstName"))
                        .body("$", hasKey("lastName"))
                        .body("$", hasKey("email"))
                        .body("$", hasKey("password"))
                        .body("$", hasKey("phone"))
                        .body("$", hasKey("userStatus"))
                        .log().all();
        }
        return response;
    }


}