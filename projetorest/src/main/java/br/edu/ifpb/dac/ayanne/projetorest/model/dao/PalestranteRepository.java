package br.edu.ifpb.dac.ayanne.projetorest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.ayanne.projetorest.model.entity.Palestrante;

public interface PalestranteRepository extends JpaRepository<Palestrante, Long> {

}
