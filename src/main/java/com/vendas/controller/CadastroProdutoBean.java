package com.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vendas.model.Categoria;
import com.vendas.model.Produto;
import com.vendas.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	private Produto produto;
	private Categoria categoriaPai;
	private List<Categoria> categoriasRaizes;
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando...");
		categoriasRaizes = categorias.raizes();
		//categoriasRaizes = manager.createQuery("from Categoria", Categoria.class).getResultList();
		// Quando finanlizar, o closeEntityManager será executado pois ele possui o @Disposes
	}
	
	public void salvar() {
		System.out.println("categoriaPai: " + categoriaPai.getDescricao());
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getcategoriasRaizes() {
		return categoriasRaizes;
	}
	
}