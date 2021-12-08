package br.ifsul.prepenem.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.prepenem.dto.UsuarioDTO;
import br.ifsul.prepenem.model.Usuario;
import br.ifsul.prepenem.repository.UsuarioRepository;
import br.ifsul.prepenem.utils.RegistroNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

	private ModelMapper mapper = new ModelMapper();
	
	private final UsuarioRepository repository;

	UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/usuarios")
	public List<UsuarioDTO> all() {
		List<Usuario> usuarios = repository.findAll();
		
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(this::converte).collect(Collectors.toList());
		
		return usuariosDTO;
	}

	@PostMapping("/usuarios")
	public ResponseEntity<?> novoUsuario(@RequestBody Usuario usuario) {
		List<Usuario> listaUsuarios = repository.findAll();
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getEmail().equals(usuario.getEmail())) {
				return new ResponseEntity<>("E-mail já cadastrado.", HttpStatus.METHOD_NOT_ALLOWED);
			}
		} 

		if (usuario.getEmail().equals("") || usuario.getSenha().equals("") || usuario.getNome().equals("")
				|| usuario.getDescricao().equals("") || usuario.getNumeroCelular().equals("")) {
			return new ResponseEntity<>("Algum campo em branco.", HttpStatus.METHOD_NOT_ALLOWED);

		} else {
			Usuario salvo = repository.save(usuario);
						
			UsuarioDTO salvoDTO = converte(salvo);
			
			return new ResponseEntity<UsuarioDTO>(salvoDTO, HttpStatus.OK);
		}
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> editarUsuario(@PathVariable Long id) {	
		Usuario selecionado = repository.findById(id).orElseThrow(() -> new RegistroNotFoundException(id));
		
		UsuarioDTO selecionadoDTO = converte(selecionado);
		
		return new ResponseEntity<UsuarioDTO>(selecionadoDTO, HttpStatus.OK);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
		return repository.findById(id).map(usuario -> {
			usuario.setEmail(newUsuario.getEmail());
			usuario.setSenha(newUsuario.getSenha());
			usuario.setNome(newUsuario.getNome());
			usuario.setDescricao(newUsuario.getDescricao());
			usuario.setNumeroCelular(newUsuario.getNumeroCelular());
			usuario.setProfessor(newUsuario.isProfessor());
			Usuario salvo = repository.save(usuario);			
			UsuarioDTO salvoDTO = converte(salvo);
			return new ResponseEntity<UsuarioDTO>(salvoDTO, HttpStatus.OK);
		}).orElseGet(() -> {
			newUsuario.setId(id);
			Usuario salvo = repository.save(newUsuario);			
			UsuarioDTO salvoDTO = converte(salvo);
			return new ResponseEntity<UsuarioDTO>(salvoDTO, HttpStatus.OK);
		});
	}

	@DeleteMapping("/usuarios/{id}")
	void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PostMapping("token")
	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		List<Usuario> listaUsuarios = repository.findAll();
		Usuario usuario = new Usuario();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getSenha().equals(senha) && listaUsuarios.get(i).getEmail().equals(email)) {
				String token = getJWTToken(email);
				usuario.setEmail(email);
				return new ResponseEntity<>(token, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("E-mail e senha incorretos ou em branco.", HttpStatus.METHOD_NOT_ALLOWED);
	}

	private String getJWTToken(String email) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	private UsuarioDTO converte(Usuario usuario) {
		 return mapper.map(usuario, UsuarioDTO.class);
	}
}
