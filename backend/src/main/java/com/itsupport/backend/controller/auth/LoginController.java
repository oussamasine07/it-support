package com.itsupport.backend.controller.auth;

import com.itsupport.backend.dto.LoginDTO;
import com.itsupport.backend.model.User;
import com.itsupport.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/login")
@CrossOrigin
public class LoginController {

    private final UserService userService;

    public LoginController (
           final UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> loginUser (@Valid @RequestBody LoginDTO loginDTO) {
        User user = new User();

        user.setEmail(loginDTO.email());
        user.setPassword(loginDTO.password());

        return userService.verify(user);

    }
}
