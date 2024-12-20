package com.example.linkswiftbackend.utils.config.security;

import java.util.regex.Pattern;

public class AuthVerification {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";

    public static boolean isValidEmail(String email) {
        return !Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return !Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
}
