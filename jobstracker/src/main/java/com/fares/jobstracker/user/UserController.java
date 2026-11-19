package com.fares.jobstracker.user;

import com.fares.jobstracker.user.dto.ChangePasswordRequest;
import com.fares.jobstracker.user.dto.UpdateUserRequest;
import com.fares.jobstracker.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal Long userId) {
        return userService.getById(userId);
    }

    @PatchMapping("/me")
    public UserResponse update(@AuthenticationPrincipal Long userId,
                               @Valid @RequestBody UpdateUserRequest request) {
        return userService.update(userId, request);
    }

    @PutMapping("/me/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@AuthenticationPrincipal Long userId,
                               @Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(userId, request);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal Long userId) {
        userService.delete(userId);
    }
}