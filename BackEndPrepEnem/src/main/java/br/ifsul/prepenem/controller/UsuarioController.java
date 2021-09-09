package br.ifsul.prepenem.controller;

import java.util.List;
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
import br.ifsul.prepenem.model.Usuario;
import br.ifsul.prepenem.repository.UsuarioRepository;
import br.ifsul.prepenem.utils.UsuarioNotFoundException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

	private final UsuarioRepository repository;

	UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/usuarios")
	List<Usuario> all() {
		return repository.findAll();
	}

	@PostMapping("/usuarios")
	Usuario newUsuario(@RequestBody Usuario newUsuario) {
		return repository.save(newUsuario);
	}

	@GetMapping("/usuarios/{id}")
	Usuario one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}

	@PutMapping("/usuarios/{id}")
	Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
		return repository.findById(id).map(usuario -> {
			usuario.setNomeCompleto(newUsuario.getNomeCompleto());
			usuario.setEmail(newUsuario.getEmail());
			usuario.setSenha(newUsuario.getSenha());
			return repository.save(usuario);
		}).orElseGet(() -> {
			newUsuario.setId(id);
			return repository.save(newUsuario);
		});
	}

	@DeleteMapping("/usuarios/{id}")
	void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PostMapping("token")
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		List<Usuario> listaUsuarios = repository.findAll();
		Usuario usuario = new Usuario();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getSenha().equals(senha) && listaUsuarios.get(i).getEmail().equals(email)) {
				String token = getJWTToken(email);
				usuario.setEmail(email);
				usuario.setToken(token);
				return "{\n\"response\":\"" + token + "\"\n}";
			}
		}
		return "{\"response\":\"E-mail e senha incorretos ou em branco.\"}";
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
}
