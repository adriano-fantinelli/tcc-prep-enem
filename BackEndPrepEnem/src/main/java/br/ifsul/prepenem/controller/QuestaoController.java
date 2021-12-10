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

import br.ifsul.prepenem.dto.QuestaoDTO;
import br.ifsul.prepenem.model.Questao;
import br.ifsul.prepenem.repository.QuestaoRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;

@RestController
public class QuestaoController {

	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private final QuestaoRepository repository;
	
	QuestaoController(QuestaoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/questoes")
	public List<QuestaoDTO> get() {
		List<Questao> questoes = repository.findAll();
		List<QuestaoDTO> questoesDTO = questoes.stream().map(this::converte).collect(Collectors.toList());
		return questoesDTO;
	}

	@PostMapping("/questoes")
	public QuestaoDTO post(@RequestBody Questao questao) {
		Questao salvo = repository.save(questao);
		QuestaoDTO salvoDTO = converte(salvo);
		return salvoDTO;
	}
	
	@GetMapping("/questoes/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {		
		Questao selecionado = repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
		QuestaoDTO selecionadoDTO = converte(selecionado);
		return new ResponseEntity<QuestaoDTO>(selecionadoDTO, HttpStatus.OK);
	}
	
	@GetMapping("/questoes/{anoProva}/{matrizCurricular}")
	public List<QuestaoDTO> list(@PathVariable("anoProva") String anoProva, @PathVariable("matrizCurricular") String matrizCurricular) {
		List<Questao> questoes = repository.findQuestoesByAnoProvaAndMatrizCurricular(anoProva, matrizCurricular);
		List<QuestaoDTO> questoesDTO = questoes.stream().map(this::converte).collect(Collectors.toList());
		return questoesDTO;
	}

	@PutMapping("/questoes/{id}")
	public ResponseEntity<?> put(@RequestBody Questao newQuestao, @PathVariable Long id) {
		return repository.findById(id).map(questao -> {
			questao.setEnunciado(newQuestao.getEnunciado());
			questao.setMatrizCurricular(newQuestao.getMatrizCurricular());
			questao.setAnoProva(newQuestao.getAnoProva());
			questao.setImagem(newQuestao.getImagem());			
			Questao salvo = repository.save(questao);
			QuestaoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<QuestaoDTO>(salvoDTO, HttpStatus.OK);	
		}).orElseGet(() -> {
			newQuestao.setId(id);			
			Questao salvo = repository.save(newQuestao);
			QuestaoDTO salvoDTO = converte(salvo);
			return new ResponseEntity<QuestaoDTO>(salvoDTO, HttpStatus.OK);	
		});
	}
	
	@DeleteMapping("/questoes/{id}")
	void deleteQuestao(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	private QuestaoDTO converte(Questao questao) {
		 return mapper.map(questao, QuestaoDTO.class);
	}
}
