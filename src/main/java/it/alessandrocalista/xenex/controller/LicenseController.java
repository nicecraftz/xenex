package it.alessandrocalista.xenex.controller;

import it.alessandrocalista.xenex.XenexApplication;
import it.alessandrocalista.xenex.dto.LicenseDTO;
import it.alessandrocalista.xenex.request.body.LicenseCreationBody;
import it.alessandrocalista.xenex.request.response.LicenseCreationResponse;
import it.alessandrocalista.xenex.request.response.LicenseVerificationResponse;
import it.alessandrocalista.xenex.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/license")
public class LicenseController {
    private final LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/verify")
    public ResponseEntity<LicenseVerificationResponse> verifyLicense(@RequestParam String licenseKey) {
        Optional<LicenseDTO> licenseByKey = licenseService.getLicenseByKey(licenseKey);
        if (licenseByKey.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        LicenseVerificationResponse response = new LicenseVerificationResponse(
                "License is valid",
                true,
                licenseByKey.get()
        );

        return ResponseEntity.ok(response);
    }


    @PostMapping("/add")
    public LicenseCreationResponse createLicense(@RequestBody LicenseCreationBody body) {
        if (!body.token().equals(XenexApplication.ADMIN_TOKEN)) {
            return new LicenseCreationResponse("Invalid token", null);
        }

        LicenseDTO license = licenseService.createLicense();
        return new LicenseCreationResponse("License created successfully", license);
    }

}
