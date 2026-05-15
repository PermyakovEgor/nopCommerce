package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewAccountTest extends BaseTest {

    @Test
    @DisplayName("Создание нового аккаунта")
    @Tag("smoke")
    public void createNewAccount() {
        loginPage.isPageOpened()
                .login("will", "will")
                .openCreateAccPage()
                .inputWrite("Egor", "+89123456789", "12345", "avito.ru")
                .addressTextareaWrite("Mira", "Lenina")
                .payAddressInputWrite("Nizhniy Novgorod", "Mira", "123", "Russia")
                .liveAddressInputWrite("Moscow", "Lenina", "321", "Russia")
                .selectChoiceOption("Analyst", "Banking")
                .addressTextareaDescription("Обратить внимание, адреса разные")
                .clickSave();
        assertEquals(addedAccOrContPage.saveContact(), "EGOR", "Аккаунт не создался");
    }
}
