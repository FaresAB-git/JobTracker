package com.fares.jobstracker.user;

import com.fares.jobstracker.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getById(Long userId) {
        return userRepository.findById(userId)
                .map(UserResponse::from)
                .orElseThrow(UserNotFoundException::new);
    }
}