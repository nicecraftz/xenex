package it.alessandrocalista.xenex.mapper;

import it.alessandrocalista.xenex.entity.Customer;
import it.alessandrocalista.xenex.entity.License;
import it.alessandrocalista.xenex.dto.LicenseDTO;
import it.alessandrocalista.xenex.entity.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LicenseMapper {

    public LicenseDTO toDTO(License license) {
        return new LicenseDTO(
                license.getId(),
                license.getKey(),
                license.getCustomer().getId(),
                license.getProduct().getId(),
                license.getIssuedBy(),
                license.getIssuedAt()
        );
    }

    public License toEntity(LicenseDTO licenseDTO, Customer customer, Product product) {
        return new License(
                licenseDTO.id(),
                licenseDTO.key(),
                customer, product,
                licenseDTO.issuedBy(),
                licenseDTO.issuedAt()
        );
    }


}
