package com.artur.riprova.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artur.riprova.dtos.ArticoliDto;
import com.artur.riprova.entities.Articoli;
import com.artur.riprova.services.ArticoliService;

import lombok.extern.java.Log;

@Log
@RequestMapping("/articoli")
@Controller
public class SessionController {

	private ArticoliService artServ;
	
	public SessionController(ArticoliService art) {
		this.artServ=art;
	}
	
	@GetMapping("/cerca/all")
	public String getArticoli(ModelMap model) {
		log.info("Seleziono tutti gli articoli...");
		
		List<ArticoliDto> articoli = artServ
				.SelAll()
				.stream().limit(50).collect(Collectors.toList());
		model.addAttribute("articoli",articoli);
		
		return "articoli";
	}
	
	@GetMapping("/cerca/descrizione/{filter}")
	public String GetArticoli(
			@PathVariable("filter") String filter,
			@MatrixVariable(name="page",defaultValue="0") String page, // permette di passare i parametri http anche nel formato .../endpoint/acqua;limite=10;pagina=3
			@MatrixVariable(name="record",defaultValue="50") String record, 
			ModelMap model) {
		int pageNum = Integer.parseInt(page);
		int recForPage = Integer.parseInt(record);
		List<ArticoliDto> articoli = artServ.SelByDescrizione(filter,pageNum,recForPage);
		
		model.addAttribute("articoli",articoli);
		return "articoli";
	}
	
	@GetMapping()
	public String GetGestArt() {
		return "articoli";
	}
	
	@GetMapping(value="/search")
	public String SearchItem(
			@RequestParam("filtro") String filtro,
			@RequestParam(required=false,defaultValue="10") String selected,
			ModelMap model) {
		log.info(String.format("Ricerca articoli con filtro %s", filtro));
		
		int pageNum = 0;
		int recForPage = Integer.parseInt(selected);
		int numArt = 0;
		boolean notFound = false;
		
		ArticoliDto articolo = null;
		List<ArticoliDto> articoli = new ArrayList<ArticoliDto>();
		
		articolo = artServ.SelByCodArt(filtro);
		if(articolo==null) {
			articolo=artServ.SelByBarcode(filtro);
			if(articolo==null) {
				articoli = artServ.SelByDescrizione(filtro, pageNum, recForPage);
				numArt = artServ.NumRecords(filtro);
				
			}else {
				numArt = 1;
				articoli.add(articolo);
			}
		}else {
			numArt = 1;
			articoli.add(articolo);
		}
		
		log.info(String.format("Trovati %d articoli", numArt));
		if(articoli.isEmpty()) notFound = true;
		
		model.addAttribute("articoli",articoli);
		model.addAttribute("filtro",filtro);
		model.addAttribute("NotFound",notFound);
		
		return "articoli";
	}
	
	/*@GetMapping(value="/cerca/{params}")
	public String GetArticoliWithParams(
				@MatrixVariable(pathVar="params") Map<String,List<String>> params,
				@RequestParam("filter") String filter,
				ModelMap model
			) {
		
		int numArt = 0;
		int pageNum = 0;
		int recForPage = 10;
		
		List<String> paramPaging = params.get("paging");
		if(paramPaging != null) {
			try {
				pageNum=Integer.parseInt(paramPaging.get(0));
				recForPage=Integer.parseInt(paramPaging.get(1));
				/*int diffPage = Integer.parseInt(paramPaging.get(1));
				
				if(pageNum >= 1) pageNum += diffPage;
				pageNum = 1;
			}catch(NumberFormatException ex) {
				pageNum = 0;
				recForPage = 10;
			}
			
			log.info(String.format("Pagina: %s, records: %s", pageNum,recForPage));
		}
		
		List<String> exFilter = params.get("exfilter");
		if(exFilter != null)
		return "articoli";
	}*/
	
}

