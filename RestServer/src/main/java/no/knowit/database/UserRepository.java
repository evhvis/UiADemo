package no.knowit.database;

import no.knowit.database.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.password=:password AND user.username=:username")
    List<User> getByLogin(@Param("password") String password,@Param("username") String username);

    @Query("SELECT user FROM User user WHERE user.passKey=:token")
    List<User> getByPasskey(@Param("token") String token);
}
