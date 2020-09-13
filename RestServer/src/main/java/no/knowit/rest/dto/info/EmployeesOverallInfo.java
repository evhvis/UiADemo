package no.knowit.rest.dto.info;

import java.util.List;

public class EmployeesOverallInfo {
    private long valid;
    private long warnings;
    private long invalid;
    private long total;

    public long getValid() {
        return valid;
    }

    public EmployeesOverallInfo setValid(long valid) {
        this.valid = valid;
        return this;
    }

    public long getWarnings() {
        return warnings;
    }

    public EmployeesOverallInfo setWarnings(long warnings) {
        this.warnings = warnings;
        return this;
    }

    public long getInvalid() {
        return invalid;
    }

    public EmployeesOverallInfo setInvalid(long invalid) {
        this.invalid = invalid;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public EmployeesOverallInfo setTotal(long total) {
        this.total = total;
        return this;
    }
}
