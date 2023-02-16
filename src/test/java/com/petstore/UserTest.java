package com.petstore;

import com.petstore.payloads.CreateUserDataPayload;
import com.petstore.teststeps.UserSteps;
import com.petstore.userendpoints.UserEndpoint;
import com.petstore.userendpoints.payloadStructureCreateUser.PayloadStructureCreateUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

import java.security.SecureRandom;
import java.util.Random;

import static org.hamcrest.Matchers.hasKey;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTest {
    private final CreateUserDataPayload CREATE_USER_PAYLOADS = new CreateUserDataPayload();
    private final UserSteps USER_STEPS = new UserSteps();

    private static String userName = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String password = "";
    private static String phoneNumber = "";


    @Test
    @Disabled
    void createUserRandom(){
        PayloadStructureCreateUser payloadStructureCreateUser = CREATE_USER_PAYLOADS.createUserRandom();

        String id = USER_STEPS.createUser(payloadStructureCreateUser, 200);

        System.out.println("ID: " + id);
    }

    @Test
    @Order(1)
    void createUserInput(){

        Faker faker = new Faker();
        Random random = new SecureRandom();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userName = firstName.toLowerCase() + "." + lastName.toLowerCase();
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@fakemail.net";
        password = RandomStringUtils.randomAlphanumeric(10);
        phoneNumber = faker.phoneNumber().phoneNumberInternational();

        Integer userStatus = Integer.valueOf(random.nextInt(1, 6));


        PayloadStructureCreateUser payloadStructureCreateUser = CREATE_USER_PAYLOADS.createUserInput(userName, firstName, lastName, email, password, phoneNumber, userStatus);

        String id = USER_STEPS.createUser(payloadStructureCreateUser, 200);
    }

    @Test
    @Order(2)
    void getUser(){
        USER_STEPS.getUser(userName, 200);
        USER_STEPS.getUser("jozko-ferko", 404);
    }

}
