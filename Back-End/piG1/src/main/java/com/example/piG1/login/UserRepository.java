package com.example.piG1.login;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername (String userName);
}
