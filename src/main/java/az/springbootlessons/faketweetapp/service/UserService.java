package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.dto.response.GetAllUserResponse;
import az.springbootlessons.faketweetapp.exception.UserNotFoundException;
import az.springbootlessons.faketweetapp.mapper.UserMapper;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public GetAllUserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserToGetAllUserResponse)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
