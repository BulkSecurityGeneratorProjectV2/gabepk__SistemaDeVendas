package com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vendas.model.Produto;
import com.vendas.repository.Produtos;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private Produtos produtos;
	
	private List<Produto> produtosFiltrados;
	private String sku;
	private String nome;
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(sku, nome);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}