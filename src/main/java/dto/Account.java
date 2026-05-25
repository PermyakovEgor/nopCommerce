package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Account {

    @Builder.Default
    private String firstName = "Egor";
    @Builder.Default
    private String lastName = "Egorov";
    @Builder.Default
    private String officePhone = "";
    @Builder.Default
    private String mobilePhone = "";
    @Builder.Default
    private String title = "";
    @Builder.Default
    private String department = "";
    @Builder.Default
    private int fax = 123;
    @Builder.Default
    private String city = "";
    @Builder.Default
    private String state = "";
    @Builder.Default
    private int postalCode = 321;
    @Builder.Default
    private String country = "";
}
