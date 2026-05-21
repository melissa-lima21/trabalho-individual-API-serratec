package org.serratec.ongdeanimais.repository;

import org.serratec.ongdeanimais.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
