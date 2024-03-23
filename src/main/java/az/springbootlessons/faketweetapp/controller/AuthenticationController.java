package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.request.LoginDto;
import az.springbootlessons.faketweetapp.dto.request.RegisterDto;
import az.springbootlessons.faketweetapp.dto.response.TokenDto;
import az.springbootlessons.faketweetapp.dto.response.UserResponse;
import az.springbootlessons.faketweetapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(authenticationService.register(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
}
