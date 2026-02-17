package com.MahaTest.Controller;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Service.MahaTestRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MahaTestRegistrationController {

    private final MahaTestRegistrationService service;

    @PostMapping("/saveForm")
    public ResponseEntity<MahaTestRegistrationForm> save(
            @RequestBody MahaTestRegistrationForm form) {

        return new ResponseEntity<>(service.saveRegistration(form), HttpStatus.CREATED);
    }

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
