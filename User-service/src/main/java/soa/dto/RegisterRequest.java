package soa.dto;

public record RegisterRequest(
    String username,
    String password
) {
}