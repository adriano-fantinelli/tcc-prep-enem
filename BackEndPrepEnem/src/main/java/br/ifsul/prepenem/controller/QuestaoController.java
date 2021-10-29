package br.ifsul.prepenem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.model.Usuario;
import br.ifsul.prepenem.repository.QuestaoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class QuestaoController {

	@Autowired
	private final QuestaoRepository repository;
	
	QuestaoController(QuestaoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/questoes")
	List<Questao> all() {
		return repository.findAll();
	}
	
	@PostMapping("/questoes")
	Questao newQuestao(@RequestBody Questao newQuestao) {
		return repository.save(newQuestao);		
	}
	
	@GetMapping("/questoes/{id}")
	Questao one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
	}
	
	@GetMapping("/questoes/{anoProva}/{matrizCurricular}")
	List<Questao> list(@PathVariable("anoProva") String anoProva, @PathVariable("matrizCurricular") String matrizCurricular) {
		return repository.findQuestoesByAnoProvaAndMatrizCurricular(anoProva, matrizCurricular);
	}

	@PutMapping("/questoes/{id}")
	Questao replaceQuestao(@RequestBody Questao newQuestao, @PathVariable Long id) {
		return repository.findById(id).map(questao -> {
			questao.setEnunciado(newQuestao.getEnunciado());
			questao.setMatrizCurricular(newQuestao.getMatrizCurricular());
			questao.setAnoProva(newQuestao.getAnoProva());
			questao.setImagem(newQuestao.getImagem());
			return repository.save(questao);
		}).orElseGet(() -> {
			newQuestao.setId(id);
			return repository.save(newQuestao);
		});
	}
	
	@DeleteMapping("/questoes/{id}")
	void deleteQuestao(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
