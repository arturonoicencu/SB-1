package com.artur.riprova.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.artur.riprova.entities.Articoli;
import com.artur.riprova.services.ArticoliService;

@Controller
public class SessionController {

	private ArticoliService artServ;
	
	public SessionController(ArticoliService art) {
		this.artServ=art;
	}
	@GetMapping("/articoli")
	public String getArticoli(ModelMap model) {
		List<Articoli> articoli = artServ.getAll();
		model.addAttribute("articoli",articoli);
		
		return "articoli";
	}
}
