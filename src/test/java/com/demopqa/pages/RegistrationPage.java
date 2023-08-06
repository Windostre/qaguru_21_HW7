package com.demopqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Student Registration Form description
 * <a href="https://demoqa.com/automation-practice-form">...</a>
 */
public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement submitButton = $("#submit");
    SelenideElement modalWindow = $(".modal-dialog");
    SelenideElement modalWindowHeader = $("#example-modal-sizes-title-lg");
    SelenideElement tableInModalWindow = $(".table-responsive");
    SelenideElement subjectInput =  $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement stateDropDown =  $("#state");
    SelenideElement cityDropDown =  $("#city");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");


    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    public void selectGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
    }

    public void setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
    }

    public void setHobby(String hobby) {
        hobbiesCheckBox.$(byText(hobby)).click();
    }

    public void setAddress(String address) {
        addressInput.setValue(address);
    }

    public void submitForm() {
        submitButton.click();
    }

    public void waitModalWindowIsOpened() {
        modalWindow.should(Condition.appear);
        modalWindowHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkModalWindowHasText(List <String> texts) {
        texts.forEach(values -> tableInModalWindow.shouldHave(text(values)));
    }

    public void checkValueNextToColumnInTableInModalWindow(String columnName, String expectedValue) {
        tableInModalWindow.$(byText(columnName)).sibling(0)
                .shouldHave(text(expectedValue));
    }

    public void waitUntilRegistrationPageIsLoaded() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath("files/jpg/" + fileName);
    }

    public void selectState(String state) {
       stateDropDown.click();
        stateCityWrapper.$(byText(state)).click();
    }

    public void selectCity(String city) {
        cityDropDown.click();
        stateCityWrapper.$(byText(city)).click();
    }
}
