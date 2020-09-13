package no.knowit;

import no.knowit.database.entities.*;
import no.knowit.rest.dto.info.EmployeeHireType;
import no.knowit.database.EmployeeRepository;
import no.knowit.database.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, EmployeeRepository employeeRepository) {
        return args -> {
            long orgNumemrKnowit = 123451234;
            long orgNumemrBygger = 123451236;
            Arrays.asList(
                 new User("Admin", "sjef", "KnowIt Sør", "admin@knowit.no")
                         .setPassword("admin").setRole(Role.ADMIN).setPassKey("9750cf16-afb9-11ea-b3de-0242ac130004").setUsername("admin").setOrgnummer(orgNumemrKnowit),
                 new User("User", "bruker", "KnowIt Sør", "bruker@knowit.no")
                         .setPassword("user").setRole(Role.COMPANY_USER).setPassKey("9b5ea182-afb9-11ea-b3de-0242ac130004").setUsername("user").setOrgnummer(orgNumemrBygger)
            ).forEach(userRepository::save);
            userRepository.findAll().forEach(System.out::println);
            Arrays.asList(
                    new EmployeeEntity().setHireType(EmployeeHireType.HIRED).setFirstName("John").setLastName("doe").setCompany("KnowIt")
                            .setBirthday(LocalDate.of(1978, 11, 5)).setWorkingRole(WorkingRole.PROJECT_LEADER),
                    new EmployeeEntity().setHireType(EmployeeHireType.HIRED)
                            .setFirstName("Jane").setLastName("doe").setCompany("KnowIt")
                            .setBirthday(LocalDate.of(1975, 1, 3)).setWorkingRole(WorkingRole.PROGRAMMER),
                    new EmployeeEntity().setHireType(EmployeeHireType.PROBATION)
                            .setFirstName("surre").setLastName("kopp").setCompany("KnowIt")
                            .setBirthday(LocalDate.of(1988, 3, 3)).setWorkingRole(WorkingRole.EMPLOYEE),
                    new EmployeeEntity().setHireType(EmployeeHireType.INVALID)
                            .setFirstName("surre").setLastName("kopp2").setCompany("KnowIt")
                            .setBirthday(LocalDate.of(1999, 9, 9)).setWorkingRole(WorkingRole.PROJECT_LEADER),
                    new EmployeeEntity().setHireType(EmployeeHireType.HIRED)
                            .setFirstName("ikke").setLastName("tilgang").setCompany("KnowIt")
                            .setBirthday(LocalDate.of(1959, 12, 3)).setWorkingRole(WorkingRole.EMPLOYEE)
            ).forEach(employeeRepository::save);
            employeeRepository.findAll().forEach(System.out::println);
        };
    }
}
