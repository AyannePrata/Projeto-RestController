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

import br.edu.ifpb.dac.ayanne.projetorest.model.entity.Palestrante;
import br.edu.ifpb.dac.ayanne.projetorest.model.service.PalestranteService;

@RestController
@RequestMapping("/api/palestrante")
public class PalestranteController {
	@Autowired
	private PalestranteService palestranteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Palestrante salvar(@RequestBody Palestrante palestrante) {
		return palestranteService.salvar(palestrante);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Palestrante> listaPalestrante() {
		return palestranteService.listaPalestrante();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Palestrante buscarPalestrantePorId(@PathVariable("id") Long id) {
		return palestranteService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestrante nÃ£o encontrado!"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPalentrante(@PathVariable("id") Long id) {
		palestranteService.buscarPorId(id)
		.map(palestrante -> {
			palestranteService.removerPorId(palestrante.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestrante nÃ£o encontrado!"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPalestrante(@PathVariable("id") Long id, @RequestBody Palestrante palestrante) {
		palestranteService.buscarPorId(id)
		.map(palestranteBase -> {
			modelMapper.map(palestrante, palestranteBase);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palestrante nÃ£o encontrado!"));
	}


}
