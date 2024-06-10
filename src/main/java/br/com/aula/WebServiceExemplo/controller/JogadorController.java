package br.com.aula.WebServiceExemplo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.WebServiceExemplo.model.dto.JogadorDTO;
import br.com.aula.WebServiceExemplo.model.dto.TimesDTO;
import br.com.aula.WebServiceExemplo.model.entity.Jogador;
import br.com.aula.WebServiceExemplo.repository.JogadorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class JogadorController {

	@Autowired
	private JogadorRepository jRep;
	
	@GetMapping("/jogador")
	public List<JogadorDTO> getAllJogador() {
		List<Jogador> listaJogador = jRep.findJogadoresDataConv();
		List<JogadorDTO> listaJogadorDTO = converteListaJogador(listaJogador);
		return listaJogadorDTO;
	}

	@GetMapping("/jogador/{codigo}")
	public ResponseEntity<JogadorDTO> getJogador(@PathVariable(value = "codigo") int codigo) {
		Jogador j = jRep.findJogadorDataConv(codigo);
		JogadorDTO jDTO = converteJogador(j);
		return ResponseEntity.ok().body(jDTO);
	}
		
	@PostMapping("/jogador")
	public ResponseEntity<String> insertJogador(@Valid @RequestBody Jogador j) {
		jRep.save(j);
		return ResponseEntity.ok().body("Jogador inserido com sucesso");
	}
	
	@PutMapping("/jogador")
	public ResponseEntity<String> updateJogador(@Valid @RequestBody Jogador j) {
		jRep.save(j);
		return ResponseEntity.ok().body("Jogador atualizado com sucesso");
	}
	
	@DeleteMapping("/jogador")
	public ResponseEntity<String> deleteJogador(@Valid @RequestBody Jogador j) {
		jRep.delete(j);
		return ResponseEntity.ok().body("Jogador excluído com sucesso");
	}
	
	private JogadorDTO converteJogador(Jogador j) {
		JogadorDTO jDTO = new JogadorDTO();
		jDTO.setCodigo(j.getCodigo());
		jDTO.setNomeJogador(j.getNomeJogador());
		jDTO.setSexo(j.getSexo());
		jDTO.setAltura(j.getAltura());
		jDTO.setDt_nasc(j.getDt_nasc());
		
		TimesDTO tDTO = new TimesDTO();
		tDTO.setId(j.getTimes().getId());
		tDTO.setNome(j.getTimes().getNome());
		tDTO.setCidade(j.getTimes().getCidade());
		
		jDTO.setTimes(tDTO);
		
		return jDTO;
	}

	private List<JogadorDTO> converteListaJogador(List<Jogador> listaJogador) {
		ArrayList<JogadorDTO> listaJogadorDTO = new ArrayList<JogadorDTO>();
		for (Jogador j : listaJogador) {
			JogadorDTO jDTO = new JogadorDTO();
			jDTO.setCodigo(j.getCodigo());
			jDTO.setNomeJogador(j.getNomeJogador());
			jDTO.setSexo(j.getSexo());
			jDTO.setAltura(j.getAltura());
			jDTO.setDt_nasc(j.getDt_nasc());
			
			TimesDTO tDTO = new TimesDTO();
			tDTO.setId(j.getTimes().getId());
			tDTO.setNome(j.getTimes().getNome());
			tDTO.setCidade(j.getTimes().getCidade());
			
			jDTO.setTimes(tDTO);
			
			listaJogadorDTO.add(jDTO);
		}
		return listaJogadorDTO;
	
	}	
	
}
