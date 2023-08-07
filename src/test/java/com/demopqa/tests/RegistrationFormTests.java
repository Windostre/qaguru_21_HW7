package com.demopqa.tests;

import com.demopqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegistrationFormTests extends TestBase{
    private RegistrationPage registrationPage = new RegistrationPage();
    private String registrationPageUrl = "/automation-practice-form";
    String firstName = "Василиса",
            lastName = "Премудрая",
            email = "pretty_vasya@mail.com";

    @Test
    void registrationFormSuccessTest() {
//        String firstName = "Василиса",
//                lastName = "Премудрая",
//                email = "pretty_vasya@mail.com";
        registrationPage
                .openPage(registrationPageUrl)
                .waitUntilRegistrationPageIsLoaded()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber("1234567890")
                .selectGender("Female")
                .setBirthDate("30", "July", "1989")
                .setSubject("Hindi")
                .setHobby("Sports")
                .uploadFile("test.jpg")
                .setAddress("Лукоморье, Дуб Зеленый, 1")
                .selectState("NCR")
                .selectCity("Delhi")
                .submitForm()
                .waitModalWindowIsOpened()
                .checkValueNextToColumnInTableInModalWindow("Student Name", "Василиса Премудрая")
                .checkValueNextToColumnInTableInModalWindow("Student Email", email)
                .checkValueNextToColumnInTableInModalWindow("Gender", "Female")
                .checkValueNextToColumnInTableInModalWindow("Mobile", "1234567890")
                .checkValueNextToColumnInTableInModalWindow("Date of Birth", "30 July,1989")
                .checkValueNextToColumnInTableInModalWindow("Subjects", "Hindi")
                .checkValueNextToColumnInTableInModalWindow("Hobbies", "Sports")
                .checkValueNextToColumnInTableInModalWindow("Picture", "test.jpg")
                .checkValueNextToColumnInTableInModalWindow("Address", "Лукоморье, Дуб Зеленый, 1")
                .checkValueNextToColumnInTableInModalWindow("State and City", "NCR Delhi");

    }

    @Test
    void registrationFormSuccessMinimalTest() {
        registrationPage
                .openPage(registrationPageUrl)
                .waitUntilRegistrationPageIsLoaded()
                .setFirstName("Василиса")
                .setLastName("Премудрая")
                .setEmail("pretty_vasya@mail.com")
                .setUserNumber("1234567890")
                .selectGender("Female")
                .submitForm()
                .waitModalWindowIsOpened()
                .checkModalWindowHasText(List.of("Василиса", "Премудрая", "1234567890", "Female"));
    }
}
