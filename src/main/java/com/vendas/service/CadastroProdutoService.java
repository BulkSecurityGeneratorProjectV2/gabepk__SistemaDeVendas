package com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vendas.model.Produto;
import com.vendas.repository.Produtos;
import com.vendas.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSKU(produto.getSku());
		
		if (produtoExistente != null) {
			throw new NegocioException("Já existe um produto com o SKU informado");
		}
		// TODO 
		return produtos.guardar(produto);
	}
}
