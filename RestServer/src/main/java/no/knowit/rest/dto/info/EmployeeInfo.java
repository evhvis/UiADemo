package no.knowit.rest.dto.info;

import no.knowit.database.entities.WorkingRole;

import java.time.LocalDate;

public class EmployeeInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private EmployeeHireType hireType;
    private LocalDate birthday;
    private WorkingRole workingRole;

    public Long getId() {
        return id;
    }

    public EmployeeInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public EmployeeInfo setCompany(String company) {
        this.company = company;
        return this;
    }

    public EmployeeHireType getHireType() {
        return hireType;
    }

    public EmployeeInfo setHireType(EmployeeHireType hireType) {
        this.hireType = hireType;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public EmployeeInfo setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public WorkingRole getWorkingRole() {
        return workingRole;
    }

    public EmployeeInfo setWorkingRole(WorkingRole workingRole) {
        this.workingRole = workingRole;
        return this;
    }
}
