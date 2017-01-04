package com.vendas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vendas.model.Produto;

import org.apache.commons.lang3.StringUtils;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	public Produto porSKU(String sku) {
		try {
		return manager.createQuery("from Produto where sku = :sku", Produto.class)
				.setParameter("sku", sku.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(String sku, String nome) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class); // Pode add restriçoes na busca
		
		if (StringUtils.isNotBlank(sku)) {
			criteria.add(Restrictions.eq("sku", sku));
		}
		
		// where nome like '%nome%', MatchMode do '%' diz que quer 'nome' em qualquer lugar da string
		if(StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)); // case insensitive
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}

}
