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
import br.ifsul.prepenem.model.Desempenho;
import br.ifsul.prepenem.repository.AlternativaReposity;
import br.ifsul.prepenem.repository.DesempenhoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class DesempenhoController {
	
	@Autowired
	private final DesempenhoRepository repository;
	
	DesempenhoController(DesempenhoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/desempenhos")
	List<Desempenho> all() {
		return repository.findAll();
	}
	
	@PostMapping("/desempenhos")
	Desempenho newDesempenho(@RequestBody Desempenho newDesempenho) {
		return repository.save(newDesempenho);		
	}
	
	@GetMapping("/desempenhos/{id}")
	Desempenho one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
	}

	@PutMapping("/desempenhos/{id}")
	Desempenho replaceDesempenho(@RequestBody Desempenho newDesempenho, @PathVariable Long id) {
		return repository.findById(id).map(desempenho -> {
			desempenho.setUsuario(newDesempenho.getUsuario());
			desempenho.setMatrizCurricular(newDesempenho.getMatrizCurricular());
			desempenho.setNumeroRespondidas(newDesempenho.getNumeroRespondidas());
			desempenho.setNumeroAcertos(newDesempenho.getNumeroAcertos());
			return repository.save(desempenho);
		}).orElseGet(() -> {
			newDesempenho.setId(id);
			return repository.save(newDesempenho);
		});
	}
	
	@DeleteMapping("/desempenhos/{id}")
	void deleteDesempenho(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
