package CRUD.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    public SecurityController(PasswordEncoder passwordEncoder) {

    }

    @GetMapping("/open")
    public String open(){
        return "OPEN";
    }

    @GetMapping("/closed")
    public String closed(){
        return "CLOSED";
    }

}
