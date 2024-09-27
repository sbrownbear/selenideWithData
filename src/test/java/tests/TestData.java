package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            studentName = firstName + " " + lastName,
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.number().numberBetween(1000000000l, 9999999999l) + "",
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = faker.number().numberBetween(1900, 2022) + "",
            fullDateOfBirth = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth,
            subjects = faker.options().option("Chemistry", "Computer Science", "Commerce", "Accounting",
            "Economics", "Social Studies", "Civics", "English", "Arts", "History", "Maths", "Phisics", "Biology", "Hindi"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "img/1.png",
            verifyPicture = "1.png",
            currentAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state),
            stateAndCity = state + " " + city;


    public String setCity(String state1) {
        String city = new String();
        switch (state1) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
        }
        return city;
    }
}
