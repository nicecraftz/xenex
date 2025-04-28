package it.alessandrocalista.xenex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.UUID;

@Entity
@Table(name = "licenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private UUID key;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Product product;
    @Column(nullable = false, name = "issued_by")
    private String issuedBy;
    @Column(nullable = false, name = "issued_at")
    @CurrentTimestamp
    private long issuedAt;

    public License(Customer customer, Product product, String issuedBy) {
        this.key = UUID.randomUUID();
        this.customer = customer;
        this.product = product;
        this.issuedBy = issuedBy;
    }
}
