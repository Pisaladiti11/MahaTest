package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.MahaTestRegistrationForm;
import com.MahaTest.Repository.MahaTestRegistrationRepository;
import com.MahaTest.Service.MahaTestRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MahaTestRegistrationServiceImpl
        implements MahaTestRegistrationService {

    private final MahaTestRegistrationRepository repository;

    @Override
    public MahaTestRegistrationForm saveRegistration(MahaTestRegistrationForm form) {

        // Duplicate mobile check
        repository.findByMobNo(form.getMobNo()).ifPresent(existing -> {
            throw new RuntimeException("Mobile number already registered!");
        });

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
}

