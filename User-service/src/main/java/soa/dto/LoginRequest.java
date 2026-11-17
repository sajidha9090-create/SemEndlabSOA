package soa.dto;



public record LoginRequest(
    String username,
    String password
) {
}