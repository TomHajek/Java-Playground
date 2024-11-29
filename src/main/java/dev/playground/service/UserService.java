package dev.playground.service;

import dev.playground.persistence.dto.RegistrationDto;
import dev.playground.persistence.entity.User;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);
    User findByEmail(String email);
    User findByUsername(String username);

}
