package com.mmit.converters;

import com.mmit.entities.Category;
import com.mmit.services.CategoryService;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class CategoryConverter implements Converter<Category>{

	@Inject
	private CategoryService service;
	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String id) {
		if(id != null) {
			var cat = service.findById(Integer.parseInt(id));
			return cat;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Category value) {
		System.out.println("category id = " + value.getId());
		return String.valueOf(value.getId());
	}

}
