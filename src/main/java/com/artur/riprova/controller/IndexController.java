package com.artur.riprova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	private String saluti = "Paragrafo generato da IndexController";
	private String paragraph = "Esegui il <a href='/prova/login'>Login</a>";
	
	@GetMapping(value="/")
	public String getWelcome(Model model) {
		return "home";
	}
	
	@RequestMapping(value="index")
	public String getWelcomeReqMap(Model model,@RequestParam(name="name",required=false,defaultValue="guest") String nome) {
		model.addAttribute("intestazione", String.format("Benvenuto %s nella pagina index", nome));
		model.addAttribute("link","/prova");
		model.addAttribute("para",paragraph);
		
		return "index";
	}
}
