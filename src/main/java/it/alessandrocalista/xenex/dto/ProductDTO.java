package it.alessandrocalista.xenex.dto;

public record ProductDTO(
        Long id,
        String name,
        String version,
        String description,
        long releaseDate
) {
}
