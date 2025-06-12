package com.itsupport.backend.repository;

import com.itsupport.backend.model.BreakDown;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakDownRepository extends JpaRepository<BreakDown, Integer> {
    List<BreakDown> findByUser(User user);
}