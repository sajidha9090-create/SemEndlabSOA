package soa.dto;



public record AuthResponse(
    String token,
    String tokenType,
    long expiresIn
) {
}