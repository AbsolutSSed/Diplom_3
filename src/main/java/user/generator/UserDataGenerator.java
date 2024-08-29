package user.generator;

import com.github.javafaker.Faker;

public class UserDataGenerator {
    private final Faker faker = new Faker();

    public String generateUserEmail() {
        return faker.internet().emailAddress();
    }
    public String generateUserName() {
        return faker.name().firstName();
    }
    public String generateUserPassword(int minLenght,int maxLenght) {
        return faker.internet().password(minLenght,maxLenght);
    }
}
