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
    CalendarComponent calendar = new CalendarComponent();
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
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesCheckBox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage waitModalWindowIsOpened() {
        modalWindow.should(Condition.appear);
        modalWindowHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkModalWindowHasText(List <String> texts) {
        texts.forEach(values -> tableInModalWindow.shouldHave(text(values)));
        return this;
    }

    public RegistrationPage checkValueNextToColumnInTableInModalWindow(String columnName, String expectedValue) {
        tableInModalWindow.$(byText(columnName)).sibling(0)
                .shouldHave(text(expectedValue));
        return this;
    }

    public RegistrationPage waitUntilRegistrationPageIsLoaded() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath("files/jpg/" + fileName);
        return this;
    }

    public RegistrationPage selectState(String state) {
       stateDropDown.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityDropDown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
}
