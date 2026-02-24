package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Repository.MahaTestRegistrationRepository;
import com.MahaTest.Security.JwtUtil;
import com.MahaTest.Service.MahaTestRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MahaTestRegistrationServiceImpl
        implements MahaTestRegistrationService {

    private final MahaTestRegistrationRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public MahaTestRegistrationForm saveRegistration(MahaTestRegistrationForm form) {

        repository.findByMobNo(form.getMobNo()).ifPresent(existing -> {
            throw new RuntimeException("Mobile number already registered!");
        });

        // 🔐 Encrypt password before saving
        form.setPassword(passwordEncoder.encode(form.getPassword()));

        return repository.save(form);
    }

    @Override
    public MahaTestRegistrationForm getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }

    @Override
    public List<MahaTestRegistrationForm> getAll() {
        return repository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        repository.deleteById(id);
        return "Registration deleted successfully";
    }

    @Override
    public String login(String mobNo, String password) {

        MahaTestRegistrationForm user = repository.findByMobNo(mobNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }

        return jwtUtil.generateToken(mobNo);
    }
}