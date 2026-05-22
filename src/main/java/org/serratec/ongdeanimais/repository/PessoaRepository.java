package org.serratec.ongdeanimais.repository;

import java.util.Optional;

import org.serratec.ongdeanimais.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Optional<Pessoa> findByEmail(String email);
}
