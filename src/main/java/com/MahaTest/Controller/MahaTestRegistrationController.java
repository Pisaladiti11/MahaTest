package com.MahaTest.Controller;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Service.MahaTestRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MahaTestRegistrationController {

    private final MahaTestRegistrationService service;


    @PostMapping("/registerForm")
    public ResponseEntity<MahaTestRegistrationForm> register(
            @RequestBody MahaTestRegistrationForm form) {

        return new ResponseEntity<>(
                service.saveRegistration(form),
                HttpStatus.CREATED
        );
    }

    // LOGIN API (JWT return karega)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String mobNo = request.get("mobNo");
        String password = request.get("password");

        String token = service.login(mobNo, password);

        return ResponseEntity.ok(Map.of("token", token));
    }

    //  PROTECTED APIs (JWT required)

    @GetMapping("/getFormById/{id}")
    public ResponseEntity<MahaTestRegistrationForm> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/getAllForms")
    public ResponseEntity<List<MahaTestRegistrationForm>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/deleteForm/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}