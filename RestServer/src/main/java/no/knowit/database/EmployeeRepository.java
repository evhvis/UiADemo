package no.knowit.database;

import no.knowit.database.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {


    @Query("SELECT employee FROM EmployeeEntity employee WHERE employee.company=:company")
    List<EmployeeEntity> findByCompany(@Param("company") String company);
}
