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

import br.ifsul.prepenem.dto.DesempenhoDTO;
import br.ifsul.prepenem.dto.DesempenhoUsuarioDTO;
import br.ifsul.prepenem.model.Desempenho;
import br.ifsul.prepenem.repository.DesempenhoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class DesempenhoController {
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private final DesempenhoRepository repository;
	
	DesempenhoController(DesempenhoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/desempenhos")
	public List<DesempenhoDTO> get() {		
		List<Desempenho> desempenhos = repository.findAll();
		List<DesempenhoDTO> desempenhosDTO = desempenhos.stream().map(this::converte).collect(Collectors.toList());
		return desempenhosDTO;
	}
	
	@PostMapping("/desempenhos")
	public DesempenhoDTO post(@RequestBody Desempenho desempenho) {		
		Desempenho salvo = repository.save(desempenho);
		DesempenhoDTO salvoDTO = converte(salvo);
		return salvoDTO;
	}
	
	@GetMapping("/desempenhos/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {		
		Desempenho selecionado = repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
		DesempenhoDTO selecionadoDTO = converte(selecionado);
		return new ResponseEntity<DesempenhoDTO>(selecionadoDTO, HttpStatus.OK);
	}
	
	@GetMapping("/desempenhos/usuario/{id}")
	public ResponseEntity<?> getDesempenhoByIdUsuario(@PathVariable Long id) {		
		DesempenhoUsuarioDTO selecionadoDTO = new DesempenhoUsuarioDTO();
		int totalRespondidas = repository.encontrarTotalRespondidasPorIdUsuario(id);		
		int totalRespondidasCorretamente = repository.encontrarTotalRespondidasCorretamentePorIdUsuario(id);
		int totalRespondidasIncorretamente = totalRespondidas - totalRespondidasCorretamente;
		double porcentagemDeAcerto = (totalRespondidasCorretamente*100)/totalRespondidas;
		
		selecionadoDTO.setTotalRespondidas(totalRespondidas);
		selecionadoDTO.setTotalRespondidasCorretamente(totalRespondidasCorretamente);
		selecionadoDTO.setTotalRespondidasIncorretamente(totalRespondidasIncorretamente);
		selecionadoDTO.setPorcentagemDeAcerto(porcentagemDeAcerto);
		return new ResponseEntity<DesempenhoUsuarioDTO>(selecionadoDTO, HttpStatus.OK);
	}

	@PutMapping("/desempenhos/{id}")
	public ResponseEntity<?> put(@RequestBody Desempenho newDesempenho, @PathVariable Long id) {
		return repository.findById(id).map(desempenho -> {
			desempenho.setUsuario(newDesempenho.getUsuario());
			desempenho.setQuestao(newDesempenho.getQuestao());
			desempenho.setRespondidaCorretamente(newDesempenho.getRespondidaCorretamente());
			Desempenho salvo = repository.save(desempenho);
			DesempenhoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<DesempenhoDTO>(salvoDTO, HttpStatus.OK);			
		}).orElseGet(() -> {
			newDesempenho.setId(id);			
			Desempenho salvo = repository.save(newDesempenho);
			DesempenhoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<DesempenhoDTO>(salvoDTO, HttpStatus.OK);
		});
	}
	
	@DeleteMapping("/desempenhos/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	private DesempenhoDTO converte(Desempenho desempenho) {
		 return mapper.map(desempenho, DesempenhoDTO.class);
	}
}
