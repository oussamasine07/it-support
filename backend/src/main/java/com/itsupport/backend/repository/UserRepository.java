package com.itsupport.backend.repository;


import com.itsupport.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);
    Optional<User> findByEmail(String email);

}
