package br.ifsul.prepenem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifsul.prepenem.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

	@Query("FROM Questao WHERE anoProva=:anoProva AND matrizCurricular=:matrizCurricular")
	List<Questao> findQuestoesByAnoProvaAndMatrizCurricular(String anoProva, String matrizCurricular);

}
