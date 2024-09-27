package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#Advertisement-Section').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(data.firstName);
        $("#lastName").setValue(data.lastName);
        $("#userEmail").setValue(data.userEmail);
        $("#genterWrapper").$(byText(data.gender)).click();
        $("#userNumber").setValue(data.userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(data.monthOfBirth);
        $(".react-datepicker__year-select").selectOption(data.yearOfBirth);
        $(".react-datepicker__day--0" + data.dayOfBirth +
                ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(data.subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(data.hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(data.picture);
        $("#currentAddress").setValue(data.currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(data.state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(data.city)).click();
        $("#submit").click();

        $(".modal-dialog").shouldHave(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(data.studentName),
                text(data.userEmail), text(data.gender), text(data.userNumber),
                text(data.fullDateOfBirth), text(data.subjects), text(data.hobbies),
                text(data.verifyPicture), text(data.currentAddress), text(data.stateAndCity));
    }
}