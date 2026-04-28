package com.MahaTest.ServiceImpl;


import com.MahaTest.Entity.UserEntity;
import com.MahaTest.Repository.UserRepository;
import com.MahaTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public List<UserEntity> getAllUsers() {
            return userRepository.findAll();
        }
    }

