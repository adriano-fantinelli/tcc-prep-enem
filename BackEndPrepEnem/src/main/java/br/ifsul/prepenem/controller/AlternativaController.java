package br.ifsul.prepenem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.prepenem.dto.AlternativaDTO;
import br.ifsul.prepenem.model.Alternativa;
import br.ifsul.prepenem.repository.AlternativaReposity;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class AlternativaController {

	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private final AlternativaReposity repository;
	
	AlternativaController(AlternativaReposity repository) {
		this.repository = repository;
	}
	
	@GetMapping("/alternativas")
	public List<AlternativaDTO> get() {		
		List<Alternativa> alternativas = repository.findAll();
		List<AlternativaDTO> alternativasDTO = alternativas.stream().map(this::converte).collect(Collectors.toList());
		return alternativasDTO;
	}
	
	@PostMapping("/alternativas")
	public AlternativaDTO post(@RequestBody Alternativa alternativa) {		
		Alternativa salvo = repository.save(alternativa);
		AlternativaDTO salvoDTO = converte(salvo);
		return salvoDTO;
	}
	
	@GetMapping("/alternativas/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {		
		Alternativa selecionado = repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
		AlternativaDTO selecionadoDTO = converte(selecionado);
		return new ResponseEntity<AlternativaDTO>(selecionadoDTO, HttpStatus.OK);
	}
	
	@PutMapping("/alternativas/{id}")
	public ResponseEntity<?> put(@RequestBody Alternativa newAlternativa, @PathVariable Long id) {
		return repository.findById(id).map(alternativa -> {
			alternativa.setCorreta(newAlternativa.isCorreta());
			alternativa.setTextoAlternativa(newAlternativa.getTextoAlternativa());
			alternativa.setQuestao(newAlternativa.getQuestao());			
			Alternativa salvo = repository.save(alternativa);
			AlternativaDTO salvoDTO = converte(salvo);
			return new ResponseEntity<AlternativaDTO>(salvoDTO, HttpStatus.OK);	
		}).orElseGet(() -> {
			newAlternativa.setId(id);
			Alternativa salvo = repository.save(newAlternativa);
			AlternativaDTO salvoDTO = converte(salvo);
			return new ResponseEntity<AlternativaDTO>(salvoDTO, HttpStatus.OK);	
		});
	}

	@DeleteMapping("/alternativas/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	private AlternativaDTO converte(Alternativa alternativa) {
		 return mapper.map(alternativa, AlternativaDTO.class);
	}
}
