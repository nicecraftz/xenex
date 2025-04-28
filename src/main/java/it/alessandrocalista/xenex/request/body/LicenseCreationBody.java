package it.alessandrocalista.xenex.request.body;

public record LicenseCreationBody(
        String token,
        Long customerId,
        Long productId,
        String issuedBy
) {
}
