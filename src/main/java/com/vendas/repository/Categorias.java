package com.vendas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.vendas.model.Categoria;

public class Categorias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Categoria porId(Long id) {
		// Busca um objeto de tipo específico a partir de sua chave (id)
		return manager.find(Categoria.class, id);
	}
	
	public List<Categoria> raizes() {
		// Se a categoria não tem pai, ela é a raiz
		// categoriaPai não é uma coluna, é um atributo de Categoria
		return manager.createQuery("from Categoria where categoriaPai is null",
				Categoria.class).getResultList();
	}
	
	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return manager.createQuery("from Categoria where categoriaPai = :raiz", 
				Categoria.class)
				.setParameter("raiz", categoriaPai)
				.getResultList();
	}
	
}
