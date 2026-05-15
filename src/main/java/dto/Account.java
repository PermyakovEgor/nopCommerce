package dto;

public class Account {

    private String firstName;
    private String lastName;
    private String officePhone;
    private String mobilePhone;
    private String title;
    private String department;
    private String fax;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Account(String firstName, String lastName, String officePhone, String mobilePhone, String title,
                   String department, String fax, String city, String state, String postalCode, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officePhone = officePhone;
        this.mobilePhone = mobilePhone;
        this.title = title;
        this.department = department;
        this.fax = fax;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getFax() {
        return fax;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
