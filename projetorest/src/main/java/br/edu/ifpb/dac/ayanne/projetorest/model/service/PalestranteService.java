package br.edu.ifpb.dac.ayanne.projetorest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorest.model.dao.PalestranteRepository;
import br.edu.ifpb.dac.ayanne.projetorest.model.entity.Palestrante;

@Service
public class PalestranteService {
	
	@Autowired
	private PalestranteRepository palestranteRepository;
	
	public Palestrante salvar(Palestrante palestrante) {
		return palestranteRepository.save(palestrante);
	}
	
	public List<Palestrante> listaPalestrante() {
		return palestranteRepository.findAll();
	}
	
	public Optional<Palestrante> buscarPorId(Long id) {
		return palestranteRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		palestranteRepository.deleteById(id);
	}


}
