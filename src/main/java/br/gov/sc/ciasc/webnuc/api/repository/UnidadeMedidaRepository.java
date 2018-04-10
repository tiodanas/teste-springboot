package br.gov.sc.ciasc.webnuc.api.repository;

import br.gov.sc.ciasc.webnuc.api.domain.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long> {
//    UnidadeMedida findByCodigo(Integer codigo);
//    List<UnidadeMedida> findAllByOrderByCodigoAsc();
}
