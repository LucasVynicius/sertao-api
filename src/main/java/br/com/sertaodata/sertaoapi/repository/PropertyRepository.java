package br.com.sertaodata.sertaoapi.repository;

import br.com.sertaodata.sertaoapi.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
