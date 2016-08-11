package com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.vendas.model.EnderecoEntrega;
import com.vendas.model.Pedido;
import com.vendas.service.NegocioException;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pedido pedido;
	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public List<Integer> getItens() {
		return itens;
	}
	
}