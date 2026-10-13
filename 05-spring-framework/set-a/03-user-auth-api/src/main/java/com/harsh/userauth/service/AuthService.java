package com.harsh.userauth.service;

import com.harsh.userauth.dto.AuthResponse;
import com.harsh.userauth.dto.LoginRequest;
import com.harsh.userauth.dto.RegisterRequest;
import com.harsh.userauth.dto.UserResponse;
import com.harsh.userauth.model.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AuthService {

    private final ConcurrentMap<String, UserAccount> usersByEmail =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);
    private final PasswordEncoder passwordEncoder;

    public AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse register(RegisterRequest request) {
        String email = normalizeEmail(request.getEmail());

        String passwordHash =
                passwordEncoder.encode(request.getPassword());

        UserAccount account = new UserAccount(
                idGenerator.incrementAndGet(),
                request.getName().trim(),
                email,
                passwordHash
        );

        UserAccount existing = usersByEmail.putIfAbsent(email, account);

        if (existing != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "An account with this email already exists"
            );
        }

        return toUserResponse(account);
    }

    public AuthResponse login(LoginRequest request) {
        String email = normalizeEmail(request.getEmail());

        UserAccount account = usersByEmail.get(email);

        if (account == null
                || !passwordEncoder.matches(
                request.getPassword(),
                account.getPasswordHash())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid email or password"
            );
        }

        return new AuthResponse(
                "Login successful (demo only; no session or token issued)",
                toUserResponse(account)
        );
    }

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    private UserResponse toUserResponse(UserAccount account) {
        return new UserResponse(
                account.getId(),
                account.getName(),
                account.getEmail()
        );
    }
}