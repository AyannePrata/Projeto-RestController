package br.edu.ifpb.dac.ayanne.projetorest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.ayanne.projetorest.model.dao.PalestraRepository;
import br.edu.ifpb.dac.ayanne.projetorest.model.entity.Palestra;

@Service
public class PalestraService {
	
	@Autowired
	private PalestraRepository palestraRepository;
	
	public Palestra salvar(Palestra palestra) {
		return palestraRepository.save(palestra);
	}
	
	public List<Palestra> listaPalestra() {
		return palestraRepository.findAll();
	}
	
	public Optional<Palestra> buscarPorId(Long id) {
		return palestraRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		palestraRepository.deleteById(id);
	}


}
