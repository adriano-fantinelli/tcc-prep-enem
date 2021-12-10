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

import br.ifsul.prepenem.dto.ExplicacaoDTO;
import br.ifsul.prepenem.model.Explicacao;
import br.ifsul.prepenem.repository.ExplicacaoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class ExplicacaoController {
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private final ExplicacaoRepository repository;
	
	ExplicacaoController(ExplicacaoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/explicacoes")
	public List<ExplicacaoDTO> all() {		
		List<Explicacao> explicacoes = repository.findAll();
		List<ExplicacaoDTO> explicacoesDTO = explicacoes.stream().map(this::converte).collect(Collectors.toList());
		return explicacoesDTO;
	}
	
	@PostMapping("/explicacoes")
	public ExplicacaoDTO post(@RequestBody Explicacao explicacao) {
		Explicacao salvo = repository.save(explicacao);
		ExplicacaoDTO salvoDTO = converte(salvo);
		return salvoDTO;
	}
	
	@GetMapping("/explicacoes/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {		
		Explicacao selecionado = repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
		ExplicacaoDTO selecionadoDTO = converte(selecionado);
		return new ResponseEntity<ExplicacaoDTO>(selecionadoDTO, HttpStatus.OK);
	}
	
	@PutMapping("/explicacoes/{id}")
	public ResponseEntity<?> put(@RequestBody Explicacao newExplicacao, @PathVariable Long id) {
		return repository.findById(id).map(explicacao -> {
			explicacao.setUsuario(newExplicacao.getUsuario());
			explicacao.setQuestao(newExplicacao.getQuestao());
			explicacao.setTextoExplicacao(newExplicacao.getTextoExplicacao());			
			Explicacao salvo = repository.save(explicacao);
			ExplicacaoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<ExplicacaoDTO>(salvoDTO, HttpStatus.OK);	
		}).orElseGet(() -> {
			newExplicacao.setId(id);			
			Explicacao salvo = repository.save(newExplicacao);
			ExplicacaoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<ExplicacaoDTO>(salvoDTO, HttpStatus.OK);	
		});
	}
	
	@DeleteMapping("/explicacoes/{id}")
	void deleteExplicacao(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	private ExplicacaoDTO converte(Explicacao explicacao) {
		 return mapper.map(explicacao, ExplicacaoDTO.class);
	}
}
