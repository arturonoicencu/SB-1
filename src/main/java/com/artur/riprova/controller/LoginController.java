package com.artur.riprova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("email")
public class LoginController {
	// puoi fare una code injection anche tramite @Autowired (oltre al metodo del costruttore)
	@GetMapping(value="/login")
	public String getLogin(ModelMap model) {
		model.addAttribute("intestazione", "Pagina di Login");
		model.addAttribute("saluti", "Inserisci le tue credenziali per accedere.");
		model.addAttribute("logged", false);
		return "login";
	}
	
	
	@PostMapping("/login")
	public String doLogin(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		String testEmail = "admin@me.io";
		String testPwd = "admin";
		
		if (email.equals(testEmail) && password.equals(testPwd)) {
			model.addAttribute("email", email);
			model.addAttribute("messaggio", String.format("Login effettuato, benvenuto %s!", email));
			return "success";
		} else {
			model.addAttribute("intestazione", "Pagina di Login");
			model.addAttribute("saluti", "Inserisci le tue credenziali per accedere.");
			model.addAttribute("messaggio", "Le credenziali inserite non sono valide. Riprova.");
			model.addAttribute("logged", true); 
			return "login";
		}
	}
}
