package no.knowit.rest.dto;


import no.knowit.database.entities.EmployeeEntity;

import java.util.List;

public class BaseResponseDto {
    private int returnCode;
    private String exception;
    private List<EmployeeEntity> employees;

    public int getReturnCode() {
        return returnCode;
    }

    public BaseResponseDto setReturnCode(int returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getException() {
        return exception;
    }

    public BaseResponseDto setException(String exception) {
        this.exception = exception;
        return this;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public BaseResponseDto setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
        return this;
    }
}
