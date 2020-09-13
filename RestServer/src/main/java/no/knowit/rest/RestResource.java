package no.knowit.rest;


import no.knowit.database.EmployeeRepository;
import no.knowit.database.UserRepository;
import no.knowit.database.entities.User;
import no.knowit.rest.dto.login.LoginInfo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
@CrossOrigin(origins = "http://localhost:4200")
public class RestResource {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    public RestResource(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginInfo> postLoginRequest(@RequestBody LoginInfo body) {
        List<User> userEnitites = userRepository.getByLogin(body.getPassword(), body.getUsername());

        if (userEnitites != null && !userEnitites.isEmpty()) {
            return ResponseEntity.ok(new LoginInfo().setToken(userEnitites.get(0).getPassKey())
                    .setRole(userEnitites.get(0).getRole()));
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK");
    }
}
