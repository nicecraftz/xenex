package it.alessandrocalista.xenex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String version;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, name = "release_date")
    private long releaseDate;
}
