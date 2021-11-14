package com.eray.erdem.readingisgood.security;


// must be in config map
public class SecurityConstants {

    public static final String SIGN_UP_URL = "/api/customers";
    public static final String SECRET = "Secret";
    public static final long EXPIRATION_TIME = 432_000_00;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}