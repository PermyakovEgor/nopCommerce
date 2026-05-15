package tests;

import dto.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateContactTest extends BaseTest{

    Account account = new Account("Ivan", "Ivanov", "123456",
            "89123456789", "boss", "right", "123", "Gorohovetz",
            "Vladimirskaya oblast", "321", "Russia");

    @Test
    @DisplayName("Создание нового контакта")
    @Tag("smoke")
    public void createNewAccount() {
        loginPage.isPageOpened()
                .login("will", "will")
                .openCreateContPage()
                .inputWriteContact(account)
                .textareaWriteContact("Gorkogo, d.19 - 131", "Адреса одинаковые, кликнул чекбоксом")
                .selectCheckboxContact()
                .clickSave();
        assertEquals(addedAccOrContPage.saveContact(), "IVAN IVANOV", "Контакт не создался, либо он уже создан");
    }
}
