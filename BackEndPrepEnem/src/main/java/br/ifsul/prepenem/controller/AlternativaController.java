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

import br.ifsul.prepenem.model.Alternativa;
import br.ifsul.prepenem.repository.AlternativaReposity;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class AlternativaController {

	@Autowired
	private final AlternativaReposity repository;
	
	AlternativaController(AlternativaReposity repository) {
		this.repository = repository;
	}
	
	@GetMapping("/alternativas")
	List<Alternativa> all() {
		return repository.findAll();
	}
	
	@PostMapping("/alternativas")
	Alternativa newAlternativa(@RequestBody Alternativa newAlternativa) {
		return repository.save(newAlternativa);		
	}
	
	@GetMapping("/alternativas/{id}")
	Alternativa one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
	}

	@PutMapping("/alternativas/{id}")
	Alternativa replaceAlternativa(@RequestBody Alternativa newAlternativa, @PathVariable Long id) {
		return repository.findById(id).map(alternativa -> {
			alternativa.setCorreta(newAlternativa.isCorreta());
			alternativa.setTextoAlternativa(newAlternativa.getTextoAlternativa());
			alternativa.setQuestao(newAlternativa.getQuestao());
			return repository.save(alternativa);
		}).orElseGet(() -> {
			newAlternativa.setId(id);
			return repository.save(newAlternativa);
		});
	}
	
	@DeleteMapping("/alternativas/{id}")
	void deleteAlternativa(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
