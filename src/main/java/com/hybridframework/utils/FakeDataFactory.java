package com.hybridframework.utils;

import com.github.javafaker.Faker;

public class FakeDataFactory {
	
	private static final Faker faker = new Faker();

    // Get random name
    public static String getRandomName() {
        return faker.name().fullName();
    }

    // Get random first name
    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    // Get random last name
    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    // Get random address
    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    // Get random city
    public static String getRandomCity() {
        return faker.address().city();
    }

    // Get random country
    public static String getRandomCountry() {
        return faker.address().country();
    }

    // Get random phone number
    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    // Get random email
    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    // Get random company name
    public static String getRandomCompany() {
        return faker.company().name();
    }

    // Get random job title
    public static String getRandomJobTitle() {
        return faker.job().title();
    }

    // Get random credit card number
    public static String getRandomCreditCardNumber() {
        return faker.finance().creditCard();
    }

    // Get random product name
    public static String getRandomProduct() {
        return faker.commerce().productName();
    }

    // Get random price
    public static String getRandomPrice() {
        return faker.commerce().price();
    }

    // Get random sentence
    public static String getRandomSentence() {
        return faker.lorem().sentence();
    }

    // Get random word
    public static String getRandomWord() {
        return faker.lorem().word();
    }

    // Get random number
    public static int getRandomNumber(int bound) {
        return faker.number().numberBetween(0, bound);
    }

    // Get random boolean
    public static boolean getRandomBoolean() {
        return faker.bool().bool();
    }

    // Get random date in the past
    public static String getRandomDate() {
        return faker.date().past(30, java.util.concurrent.TimeUnit.DAYS).toString();
    }

    // Get random currency
    public static String getRandomCurrency() {
        return faker.currency().code();
    }


    // Get random color
    public static String getRandomColor() {
        return faker.color().name();
    }

    // Get random image URL
    public static String getRandomImageUrl() {
        return faker.internet().image();
    }

    // Get random IP address
    public static String getRandomIpAddress() {
        return faker.internet().ipV4Address();
    }

    // Get random username
    public static String getRandomUsername() {
        return faker.name().username();
    }

    // Get random password
    public static String getRandomPassword() {
        return faker.internet().password();
    }

}
