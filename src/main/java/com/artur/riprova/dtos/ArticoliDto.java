package com.artur.riprova.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoliDto {
	private String codArt;
	private String descrizione;
	private String um;
	private String codstat;
	private int pzcart;
	private double pesoNetto;
	private String status;
	private Date dataCreaz;
	private double prezzo=0;
	
	private Set<BarcodeDto> barcode = new HashSet<>();
	private IngredientiDto ingredienti;
	private CategoriaDto famAssort;
	private IvaDto iva;
	
	
}
