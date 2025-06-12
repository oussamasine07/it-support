package com.itsupport.backend.repository;


import com.itsupport.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    public User findUserByUsername(String username);

    public User getUserByUsernameOrEmail(String username);
}
