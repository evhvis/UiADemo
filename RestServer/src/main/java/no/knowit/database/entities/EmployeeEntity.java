package no.knowit.database.entities;

import no.knowit.rest.dto.info.EmployeeHireType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String company;
    private EmployeeHireType hireType;
    private LocalDate birthday;
    private WorkingRole workingRole;
    private boolean dummy;

    public long getId() {
        return id;
    }

    public EmployeeEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public EmployeeEntity setCompany(String company) {
        this.company = company;
        return this;
    }

    public EmployeeHireType getHireType() {
        return hireType;
    }

    public EmployeeEntity setHireType(EmployeeHireType hireType) {
        this.hireType = hireType;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public EmployeeEntity setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public WorkingRole getWorkingRole() {
        return workingRole;
    }

    public EmployeeEntity setWorkingRole(WorkingRole workingRole) {
        this.workingRole = workingRole;
        return this;
    }

    public boolean isDummy() {
        return dummy;
    }

    public EmployeeEntity setDummy(boolean dummy) {
        this.dummy = dummy;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", hireType=" + hireType +
                ", birthday=" + birthday +
                ", workingRole=" + workingRole +
                ", dummy=" + dummy +
                '}';
    }
}
