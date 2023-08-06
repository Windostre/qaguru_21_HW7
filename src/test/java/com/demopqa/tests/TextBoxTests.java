package com.demopqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.demopqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{
    private TextBoxPage textBoxPage = new TextBoxPage();
    private String textBoxPageUrl = "/text-box";

    @Test
    void testBoxTests() {
        open(textBoxPageUrl);
        textBoxPage.setFullName("Sveta Ivanova")
        .setEmail("ivanova@somemail.ru")
        .setCurrentAddress("Pushkina ul., 34")
        .setPermanentAddress("Gogol-Mogol ul., 16a")
        .submitForm()
        .checkThatTextBoxHasText("Sveta Ivanova")
        .checkThatTextBoxHasText("ivanova@somemail.ru")
        .checkThatTextBoxHasText("Pushkina ul., 34")
        .checkThatTextBoxHasText("Gogol-Mogol ul., 16a");

    }
}
