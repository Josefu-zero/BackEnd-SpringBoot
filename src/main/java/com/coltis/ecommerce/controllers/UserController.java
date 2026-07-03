package com.coltis.ecommerce.controllers;
 
import com.coltis.ecommerce.dto.*;
import com.coltis.ecommerce.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class UserController {
 
    private final UserService userService;
 
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody RegisterUserRequest request) {
        return userService.registerUser(request);
    }
 
    @PostMapping("/login")
    public UserResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
 
    @GetMapping("/{id}")
    public UserResponse readUser(@PathVariable Integer id) {
        return userService.readUser(id);
    }
 
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Integer id,
                                   @Valid @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }
 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
