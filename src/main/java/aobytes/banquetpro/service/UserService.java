package aobytes.banquetpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aobytes.banquetpro.dto.UserDTO;
import aobytes.banquetpro.models.UserEntity;
import aobytes.banquetpro.repositories.UserRepository;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(entity);
    }
}
