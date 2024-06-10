package br.com.aula.WebServiceExemplo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.WebServiceExemplo.model.dto.TimesDTO;
import br.com.aula.WebServiceExemplo.model.entity.Times;
import br.com.aula.WebServiceExemplo.repository.TimesRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TimesController {
	
	@Autowired
	private TimesRepository tRep;
	
	@GetMapping("/times")
	public List<TimesDTO> getAllTimes() {
		List<Times> listaTimes = tRep.findAll();
		List<TimesDTO> listaTimesDTO = converteListaTimes(listaTimes);
		return listaTimesDTO;
	}
	
	@GetMapping("/times/{idTime}")
	public ResponseEntity<TimesDTO> getTime(@PathVariable(value = "idTime") int idTime) 
			throws ResourceNotFoundException {
		Times time = tRep.findById(idTime).orElseThrow(
				() -> new ResourceNotFoundException(idTime+" inválido")
				);
		TimesDTO timeDTO = converteTime(time);
		return ResponseEntity.ok().body(timeDTO);
	}
	
	@PostMapping("/times")
	public ResponseEntity<String> crudTimes(@Valid @RequestBody Times t) {
		String saida = tRep.spCrudTimes(t.getCod(), t.getId(), t.getNome(), t.getCidade());
		return ResponseEntity.ok().body(saida);
	}
	
	private TimesDTO converteTime(Times t) {
		TimesDTO tDTO = new TimesDTO();
		tDTO.setId(t.getId());
		tDTO.setNome(t.getNome());
		tDTO.setCidade(t.getCidade());
		
		return tDTO;
	}
	
	private List<TimesDTO> converteListaTimes(List<Times> listaTimes) {
		List<TimesDTO> listaTimesDTO = new ArrayList<TimesDTO>();
		for (Times t : listaTimes) {
			TimesDTO tDTO = new TimesDTO();
			tDTO.setId(t.getId());
			tDTO.setNome(t.getNome());
			tDTO.setCidade(t.getCidade());
			
			listaTimesDTO.add(tDTO);
		}
		
		return listaTimesDTO;
	}

}
