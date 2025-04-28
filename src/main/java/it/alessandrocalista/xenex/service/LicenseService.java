package it.alessandrocalista.xenex.service;

import it.alessandrocalista.xenex.dto.LicenseDTO;
import it.alessandrocalista.xenex.entity.Customer;
import it.alessandrocalista.xenex.entity.License;
import it.alessandrocalista.xenex.entity.Product;
import it.alessandrocalista.xenex.mapper.LicenseMapper;
import it.alessandrocalista.xenex.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    @Autowired
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public LicenseDTO createLicense(Customer customer, Product product, String issuedBy) {
        License license = new License(customer, product, issuedBy);
        licenseRepository.save(license);
        return LicenseMapper.toDTO(license);
    }

    public Optional<LicenseDTO> getLicenseByKey(String licenseKey) {
        return Optional.ofNullable(LicenseMapper.toDTO(licenseRepository.findByKey(licenseKey)));
    }

    public List<LicenseDTO> getCustomerLicences(Long customerId) {
        return licenseRepository.findByCustomer(customerId)
                .stream()
                .map(LicenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Set<LicenseDTO> getAllLicences() {
        return licenseRepository.findAll().stream().map(LicenseMapper::toDTO).collect(Collectors.toSet());
    }

}
