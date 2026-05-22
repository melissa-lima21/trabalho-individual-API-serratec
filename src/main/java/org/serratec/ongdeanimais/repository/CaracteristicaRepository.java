package org.serratec.ongdeanimais.repository;

import org.serratec.ongdeanimais.domain.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long> {

	boolean existsByDescricao(String descricao);
}
