package br.edu.ifpb.dac.ayanne.projetorest.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifpb.dac.ayanne.projetorest.model.entity.Palestra;
import br.edu.ifpb.dac.ayanne.projetorest.model.service.PalestraService;

@RestController
@RequestMapping("/api/palestra")
public class PalestraController {
	
	@Autowired
	private PalestraService palestraService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Palestra salvar(@RequestBody Palestra palestra) {
		return palestraService.salvar(palestra);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Palestra> listaPalestra() {
		return palestraService.listaPalestra();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Palestra buscarPalestraPorId(@PathVariable("id") Long id) {
		return palestraService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestra não encontrada!"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPalentra(@PathVariable("id") Long id) {
		palestraService.buscarPorId(id)
		.map(palestra -> {
			palestraService.removerPorId(palestra.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestra não encontrada!"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPalestra(@PathVariable("id") Long id, @RequestBody Palestra palestra) {
		palestraService.buscarPorId(id)
		.map(palestraBase -> {
			modelMapper.map(palestra, palestraBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestra não encontrada!"));
	}

}
