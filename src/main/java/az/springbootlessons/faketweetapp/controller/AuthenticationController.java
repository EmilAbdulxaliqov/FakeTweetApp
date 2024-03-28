package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.request.LoginDto;
import az.springbootlessons.faketweetapp.dto.request.RegisterDto;
import az.springbootlessons.faketweetapp.dto.response.TokenDto;
import az.springbootlessons.faketweetapp.dto.response.UserResponse;
import az.springbootlessons.faketweetapp.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(authenticationService.register(registerDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
}
