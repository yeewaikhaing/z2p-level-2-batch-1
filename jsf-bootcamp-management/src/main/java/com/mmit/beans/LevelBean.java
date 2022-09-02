package com.mmit.beans;

import java.io.Serializable;
import java.util.List;

import com.mmit.model.entities.Level;
import com.mmit.model.services.LevelService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LevelBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private LevelService service;
	
	private List<Level> levels;
	@PostConstruct
	private void init() {
		levels = service.findAll();
	}
	public List<Level> getLevels() {
		return levels;
	}
	
	
}
