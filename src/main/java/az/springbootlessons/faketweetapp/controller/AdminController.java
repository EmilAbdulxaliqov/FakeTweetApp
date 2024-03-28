package az.springbootlessons.faketweetapp.controller;

import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.model.genericSearch.SearchCriteria;
import az.springbootlessons.faketweetapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @GetMapping("/search")
    public Collection<User> search(@RequestBody List<SearchCriteria> searchCriteriaList) {
        return userService.search(searchCriteriaList);
    }
}