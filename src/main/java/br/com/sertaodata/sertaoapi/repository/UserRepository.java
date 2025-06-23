package br.com.sertaodata.sertaoapi.repository;

import br.com.sertaodata.sertaoapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
