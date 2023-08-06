import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Test
    void practiceFormSuccessTest() {
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Василиса");
        $("#lastName").setValue("Премудрая");
        $("#userEmail").setValue("pretty_vasya@mail.com");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("files/jpg/test.jpg");
        $("#currentAddress").setValue("Лукоморье, Дуб Зеленый, 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Василиса Премудрая"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("pretty_vasya@mail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("30 July,1989"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Hindi"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("test.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Лукоморье, Дуб Зеленый, 1"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
    }
}
