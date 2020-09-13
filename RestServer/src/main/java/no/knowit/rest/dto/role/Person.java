package no.knowit.rest.dto.role;

public class Person {
    private String name;
    private String company;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Person setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }
}
