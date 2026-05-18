package tests;

import dto.Account;
import dto.AccountFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateContactTest extends BaseTest{

    Account account = Account.builder() //Прописанные значения в dto
            .firstName("Ivan")
            .lastName("Ivanov")
            .officePhone("123456")
            .mobilePhone("89123456789")
            .title("boss")
            .department("right")
            .fax(123)
            .city("Gorohovetz")
            .state("Vladimirskaya oblast")
            .postalCode(321)
            .country("Russia")
            .build();


    Account account2 = AccountFactory.getAccount(); //рандомные значение через faker

    Account account3 = Account.builder() //Некоторые поля пустые, заполнены стандартными значениями
            .firstName("Ivan")
            .lastName("Ivanov")
            .mobilePhone("89123456789")
            .title("boss")
            .country("Russia")
            .build();


    @Test
    @DisplayName("Создание нового контакта")
    @Tag("smoke")
    public void createNewAccount() {
        loginPage.isPageOpened()
                .login("will", "will")
                .openCreateContPage()
                .inputWriteContact(account)
                .textareaWriteContact("door cod - 1234", "Адреса одинаковые, кликнул чекбоксом")
                .selectCheckboxContact()
                .clickSave();
        assertEquals(addedAccOrContPage.saveContact(), "IVAN IVANOV", "Контакт не создался, либо он уже создан");
    }
}
