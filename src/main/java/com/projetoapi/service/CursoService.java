package com.projetoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoapi.entities.Cursos;
import com.projetoapi.repository.CursosRepository;

@Service
public class CursoService {
	private CursosRepository livroRepository;

	@Autowired
	public CursoService(CursosRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public List<Cursos> buscarTodos() {
		return livroRepository.findAll();
	}

	public Cursos buscarId(Long id) {
		Optional<Cursos> Pedido = livroRepository.findById(id);
		return Pedido.orElse(null);
	}

	public Cursos salvar(Cursos usuario) {
		return livroRepository.save(usuario);
	}

	public Cursos alterar(Long id, Cursos alterarprod) {
		Optional<Cursos> existe = livroRepository.findById(id);
		if (existe.isPresent()) {
			alterarprod.setId(id);
			return livroRepository.save(alterarprod);
		}
		return null;
	}

	public boolean apagar(Long id) {
		Optional<Cursos> existe = livroRepository.findById(id);
		if (existe.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}

		return false;
	}

}