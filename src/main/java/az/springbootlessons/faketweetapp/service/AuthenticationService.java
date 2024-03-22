package az.springbootlessons.faketweetapp.service;


import az.springbootlessons.faketweetapp.dto.request.LoginDto;
import az.springbootlessons.faketweetapp.dto.request.RegisterDto;
import az.springbootlessons.faketweetapp.dto.response.TokenDto;
import az.springbootlessons.faketweetapp.dto.response.UserResponse;
import az.springbootlessons.faketweetapp.model.Role;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterDto registerDto) {
        log.info("Registering user: {}", registerDto);
        User user = User.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return UserResponse.builder().message("User registered").build();
    }

    public TokenDto login(LoginDto loginDto) {
        log.info("Logging in user: {}", loginDto.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.generateToken(user);
        return TokenDto.builder().token(token).build();
    }
}
