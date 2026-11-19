package com.fares.jobstracker.user;

import com.fares.jobstracker.auth.EmailAlreadyUsedException;
import com.fares.jobstracker.user.dto.ChangePasswordRequest;
import com.fares.jobstracker.user.dto.UpdateUserRequest;
import com.fares.jobstracker.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserResponse getById(Long userId) {
        return UserResponse.from(findUser(userId));
    }

    @Transactional
    public UserResponse update(Long userId, UpdateUserRequest request) {
        User user = findUser(userId);

        if (request.email() != null) {
            String newEmail = request.email().trim().toLowerCase();
            if (!newEmail.equals(user.getEmail()) && userRepository.existsByEmail(newEmail)) {
                throw new EmailAlreadyUsedException(newEmail);
            }
            user.setEmail(newEmail);
        }
        if (request.firstName() != null) {
            user.setFirstName(request.firstName().trim());
        }
        if (request.lastName() != null) {
            user.setLastName(request.lastName().trim());
        }

        return UserResponse.from(user);
    }

    @Transactional
    public void changePassword(Long userId, ChangePasswordRequest request) {
        User user = findUser(userId);

        if (!passwordEncoder.matches(request.currentPassword(), user.getPasswordHash())) {
            throw new InvalidCurrentPasswordException();
        }

        user.setPasswordHash(passwordEncoder.encode(request.newPassword()));
    }

    @Transactional
    public void delete(Long userId) {
        userRepository.delete(findUser(userId));
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}