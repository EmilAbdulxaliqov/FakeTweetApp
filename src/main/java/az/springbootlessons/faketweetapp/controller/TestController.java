package az.springbootlessons.faketweetapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/v1/public")
    public String publicApi() {
        return "Public API";
    }

    @GetMapping("/api/admin")
    public String adminApi() {
        return "Admin API";
    }
}
