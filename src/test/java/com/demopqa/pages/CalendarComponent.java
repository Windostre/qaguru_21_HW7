package com.demopqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    SelenideElement calendarMonth = $(".react-datepicker__month-select");
    SelenideElement calendarYear =  $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        calendarMonth.selectOption(month);
        calendarYear.selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }

}
