package it.alessandrocalista.xenex.request.response;

import it.alessandrocalista.xenex.dto.LicenseDTO;

public record LicenseVerificationResponse(
        String message,
        boolean accepted,
        LicenseDTO license
) {
}
