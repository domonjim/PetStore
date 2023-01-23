package com.petstore;

import com.petstore.payloads.CreateUserDataPayload;
import com.petstore.teststeps.UserSteps;
import com.petstore.userendpoints.payloadStructureCreateUser.PayloadStructureCreateUser;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

class UserTest {
    private final CreateUserDataPayload CREATE_USER_PAYLOADS = new CreateUserDataPayload();
    private final UserSteps USER_STEPS = new UserSteps();

    private static String userName;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;
    private static String phoneNumber;


    @Test
    void createUserRandom(){
        PayloadStructureCreateUser payloadStructureCreateUser = CREATE_USER_PAYLOADS.createUserRandom();

        String id = USER_STEPS.createUser(payloadStructureCreateUser, 200);

        System.out.println("ID: " + id);
    }

    @Test
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
    void getUser(){
        USER_STEPS.getUser(userName, 200);
    }



}
