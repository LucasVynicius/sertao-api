package br.com.sertaodata.sertaoapi.repository;

import br.com.sertaodata.sertaoapi.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}
