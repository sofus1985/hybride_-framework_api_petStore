package utilities;

import com.github.javafaker.Faker;

public class GenerateFakerData {

        private static final Faker faker = new Faker();

        public static String generateUserName() {
        return faker.name().username();
    }
        public static String generateFirstName() {
            return faker.name().firstName();
        }

        public static String generateLastName() {
            return faker.name().lastName();
        }

        public static String generateEmail() {
            return faker.internet().safeEmailAddress();
        }

        public static String generatePassword() {
            return faker.internet().password();
        }
        public static String generateIdNumber() {
        return faker.idNumber().valid();
    }

        public static String generateCellPhone() {
            return faker.phoneNumber().cellPhone();
        }

        public static String generateGender() {
            return faker.demographic().sex();
        }

        public static String generateStatus() {
            return faker.bool().bool() ? "active" : "inactive";
        }

        public static String generateAddress() {
            return faker.address().fullAddress();
        }
    }


/*
   -private static final Faker faker = new Faker();

    This line creates a single instance of the Faker class from the Java Faker library. Since this instance is static,
     it's shared across all methods in the FakerUtility class. Making it final means that it cannot be reassigned.

    - public static String generateFirstName()
    This method returns a randomly generated first name (e.g., "John", "Alice").
    The faker.name().firstName() method is called to generate the first name.
 */