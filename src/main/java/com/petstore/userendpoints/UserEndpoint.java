package com.petstore.userendpoints;

import com.petstore.userendpoints.payloadStructureCreateUser.PayloadStructureCreateUser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoint {
    private static final String URL = "https://petstore.swagger.io/v2/user";

    private static final String USER_LIST = "/createWithList";
    private static final String USER_LOGIN = "/login";
    private static final String USER_LOGOUT = "/logout";
    private static final String USERNAME_URL = URL + "/{username}";

    private static final String USERNAME = "username";

    public static Response createUser(PayloadStructureCreateUser payloadStructureCreateUser) {

        return
                given()
                        .log().all()
                        //.baseUri(URL)
                        .header("Content-Type", "application/json")
                        .when()
                        .body(payloadStructureCreateUser)
                        .post(URL)
                        .then().log().ifValidationFails().extract().response();
    }

    public static Response getUser(String userName) {

        return
                given()
                        .log().all()
                        //.baseUri(URL)
                        .header("Content-Type", "application/json")
                        .pathParam(USERNAME, userName)
                        .when()
                        .get(USERNAME_URL)
                        .then().log().ifValidationFails().extract().response();
    }


}
