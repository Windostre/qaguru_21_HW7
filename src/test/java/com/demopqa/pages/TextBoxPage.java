package com.demopqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {
    SelenideElement fullNameInput =  $("#userName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement permanentAddressInput =  $("#permanentAddress");
    SelenideElement submitButton = $("#submit");
    SelenideElement textBox =  $("#output");

    public void setFullName(String fullName) {
        fullNameInput.setValue(fullName);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
    }
    public void setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkThatTextBoxHasText(String expectedText) {
        textBox.shouldHave(Condition.text(expectedText));
    }
}
