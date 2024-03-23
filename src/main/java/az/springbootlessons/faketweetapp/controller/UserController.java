package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.response.GetAllUserResponse;
import az.springbootlessons.faketweetapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("{id}")
    public GetAllUserResponse getAll(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
