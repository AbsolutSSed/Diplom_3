package user.generator;

import com.github.javafaker.Faker;
import user.User;

public class UserDataGenerator {
    private final Faker faker = new Faker();
    private static final String SUFFIX = "TEST";
    private String addTestSuffix(String value) {
        return SUFFIX + value;
    }

    public String generateUserEmail() {
        return addTestSuffix(faker.internet().emailAddress());
    }
    public String generateUserName() {
        return addTestSuffix(faker.name().firstName());
    }
    public String generateUserPassword(int minLenght,int maxLenght) {
        return faker.internet().password(minLenght,maxLenght);
    }
    public User generateUserData() {
        User user = new User(addTestSuffix(faker.internet().emailAddress()),
                faker.dune().character(),
                addTestSuffix(faker.funnyName().name()));
        return user;
    }
}
