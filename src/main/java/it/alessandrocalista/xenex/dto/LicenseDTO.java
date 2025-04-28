package it.alessandrocalista.xenex.dto;

import java.util.UUID;

public record LicenseDTO(
        Long id,
        UUID key,
        Long customerId,
        Long productId,
        String issuedBy,
        long issuedAt
) {
}
