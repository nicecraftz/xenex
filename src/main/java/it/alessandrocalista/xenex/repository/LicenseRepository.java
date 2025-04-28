package it.alessandrocalista.xenex.repository;

import it.alessandrocalista.xenex.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM licenses WHERE key = :key")
    License findByKey(String key);

    @Query(nativeQuery = true, value = "SELECT * FROM licenses WHERE customer_id = :customerId")
    List<License> findByCustomer(Long customerId);
}