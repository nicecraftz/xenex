package it.alessandrocalista.xenex.request.response;

import it.alessandrocalista.xenex.dto.LicenseDTO;

public record LicenseCreationResponse(
        String message,
        LicenseDTO createdLicense
) {
}
