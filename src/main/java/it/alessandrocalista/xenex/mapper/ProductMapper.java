package it.alessandrocalista.xenex.mapper;

import it.alessandrocalista.xenex.dto.ProductDTO;
import it.alessandrocalista.xenex.entity.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getVersion(),
                product.getReleaseDate()
        );
    }

    public Product toEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.id(),
                productDTO.name(),
                productDTO.description(),
                productDTO.version(),
                productDTO.releaseDate()
        );
    }

}
