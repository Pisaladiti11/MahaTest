package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Repository.MahaTestRegistrationRepository;
import com.MahaTest.Security.JwtUtil;
import com.MahaTest.Service.MahaTestRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MahaTestRegistrationServiceImpl implements MahaTestRegistrationService {

    @Autowired
    private MahaTestRegistrationRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public MahaTestRegistrationForm register(MahaTestRegistrationForm user) {
        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public String login(String mobNo, String password) {
        MahaTestRegistrationForm user = repo.findByMobNo(mobNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔹 Debugging
        System.out.println("DB password: " + user.getPassword());
        System.out.println("Input password: " + password);
        System.out.println("Password matches: " + passwordEncoder.matches(password, user.getPassword()));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getMobNo());
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
    }

