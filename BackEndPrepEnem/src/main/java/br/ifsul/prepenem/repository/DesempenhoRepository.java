package br.ifsul.prepenem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifsul.prepenem.model.Desempenho;

public interface DesempenhoRepository extends JpaRepository<Desempenho, Long>{

	@Query(
	value = "SELECT COUNT(*) AS total_respondidas FROM (SELECT * FROM desempenho d WHERE d.usuario_id = :id GROUP BY d.questao_id) AS total", 
	nativeQuery = true)
	int encontrarTotalRespondidasPorIdUsuario(Long id);
	
	@Query(
	value = "SELECT COUNT(*) as total_respondidas_corretamente FROM (select * from desempenho d where d.usuario_id = :id and d.respondida_corretamente=1 GROUP BY d.questao_id) as total"
			+ "", 
	nativeQuery = true)
	int encontrarTotalRespondidasCorretamentePorIdUsuario(Long id);
	
}
