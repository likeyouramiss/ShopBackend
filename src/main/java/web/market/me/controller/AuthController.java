package web.market.me.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import web.market.me.dto.request.LoginRequest;
import web.market.me.dto.responce.UserResponse;
import web.market.me.serivce.AuthService;
import web.market.me.entity.User;
import web.market.me.dto.request.RegisterRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest registerRequest ) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
