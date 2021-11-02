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

import br.ifsul.prepenem.model.Desempenho;
import br.ifsul.prepenem.model.Explicacao;
import br.ifsul.prepenem.repository.DesempenhoRepository;
import br.ifsul.prepenem.repository.ExplicacaoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class ExplicacaoController {
	
	@Autowired
	private final ExplicacaoRepository repository;
	
	ExplicacaoController(ExplicacaoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/explicacoes")
	List<Explicacao> all() {
		return repository.findAll();
	}
	
	@PostMapping("/explicacoes")
	Explicacao newExplicacao(@RequestBody Explicacao newExplicacao) {
		return repository.save(newExplicacao);		
	}
	
	@GetMapping("/explicacoes/{id}")
	Explicacao one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
	}

	@PutMapping("/explicacoes/{id}")
	Explicacao replaceExplicacao(@RequestBody Explicacao newExplicacao, @PathVariable Long id) {
		return repository.findById(id).map(explicacao -> {
			explicacao.setUsuario(newExplicacao.getUsuario());
			explicacao.setQuestao(newExplicacao.getQuestao());
			explicacao.setTextoExplicacao(newExplicacao.getTextoExplicacao());
			return repository.save(explicacao);
		}).orElseGet(() -> {
			newExplicacao.setId(id);
			return repository.save(newExplicacao);
		});
	}
	
	@DeleteMapping("/explicacoes/{id}")
	void deleteExplicacao(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
