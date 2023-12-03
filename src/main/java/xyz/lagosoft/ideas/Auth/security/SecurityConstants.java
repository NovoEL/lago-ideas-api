package xyz.lagosoft.ideas.Auth.security;

public class SecurityConstants {
    public static final String SECRET = "oursecretkey";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v2/auth/signup";
    public static final String LOGIN_URL = "/api/v2/auth/login";
    public static final String PUBLIC_URL = "/api/v2/**/public";
}
