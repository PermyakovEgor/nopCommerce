package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount() {
        Faker faker = new Faker();
        return new Account(faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().cellPhone(),
                faker.phoneNumber().phoneNumber(), faker.job().title(), faker.job().keySkills(),
                faker.number().numberBetween(1000, 9999), faker.address().city(),
                faker.address().state(), faker.number().numberBetween(100, 999),
                faker.address().country());
    }
}
