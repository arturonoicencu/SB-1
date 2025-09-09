package com.artur.riprova.services;

import java.util.List;

import com.artur.riprova.dtos.ArticoliDto;
import com.artur.riprova.entities.Articoli;

public interface ArticoliService {

	public List<ArticoliDto> SelAll();
	//
	
	public ArticoliDto SelByCodArt(String codart);
	
	public List<ArticoliDto> SelByDescrizione(String filter,int page,int numrec);
	
	public ArticoliDto SelByBarcode(String barcode);
	
	public int NumRecords(String filter);
}
