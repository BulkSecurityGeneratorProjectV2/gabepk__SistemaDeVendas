package com.vendas.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.vendas.model.Categoria;
import com.vendas.repository.Categorias;
import com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	// INJECT não funciona com Conversores !
	//@Inject
	private Categorias categorias;
	
	public CategoriaConverter() {
		// Retorna uma instancia de um bean CDI. Alternativa para Inject
		categorias = CDIServiceLocator.getBean(Categorias.class);
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Categoria retorno = null;
		if (arg2 != null) {
			Long id = new Long(arg2);
			retorno = categorias.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Categoria) arg2).getId().toString();
		}
		return "";
	}

}
