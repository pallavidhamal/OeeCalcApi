package com.oee.security;
public interface SecurityConstants {
    String SECRET = "RqxPOuVfHoBA8Uq40MhJvfY6qEHOOWWvg6N9W9vt23s=";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String SIGN_UP_URL = "/users/sign-up";
    long EXPIRATION_TIME = 864_000_000; // 10 days
    long REFRESH_EXPIRATION_TIME = 864_000_000; // 10 days
}