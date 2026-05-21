package org.serratec.ongdeanimais.repository;

import java.util.List;

import org.serratec.ongdeanimais.domain.InteresseAdocao;
import org.serratec.ongdeanimais.enums.StatusInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseAdocaoRepository extends JpaRepository<InteresseAdocao, Long>{
	List<InteresseAdocao> findByAnimalId(Long animalId);
	
	List<InteresseAdocao> findByStatus(StatusInteresse status);
}
