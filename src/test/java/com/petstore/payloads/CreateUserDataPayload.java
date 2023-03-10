package com.petstore.payloads;

import com.petstore.userendpoints.payloadStructureCreateUser.PayloadStructureCreateUser;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;

public class CreateUserDataPayload {
    public PayloadStructureCreateUser createUserRandom(){

        Faker faker = new Faker();
        Random random = new SecureRandom();


        Integer id = Integer.valueOf(RandomStringUtils.randomNumeric(5));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = firstName.toLowerCase() + "." + lastName.toLowerCase();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@fakemail.net";
        String password = RandomStringUtils.randomAlphanumeric(10);
        String phoneNumber = faker.phoneNumber().phoneNumberInternational();

        Integer userStatus = Integer.valueOf(random.nextInt(1, 11));
        return new PayloadStructureCreateUser()
                .setId(id)
                .setUsername(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setUserStatus(userStatus);
    }

    public PayloadStructureCreateUser createUserInput(String userName, String firstName, String lastName, String email, String password,
                                                      String phoneNumber, Integer userStatus){

        Integer id = Integer.valueOf(RandomStringUtils.randomNumeric(5));

        return new PayloadStructureCreateUser()
                .setId(id)
                .setUsername(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phoneNumber)
                .setUserStatus(userStatus);
    }



}
