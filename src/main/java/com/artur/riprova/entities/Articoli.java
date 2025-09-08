package com.artur.riprova.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articoli {
	private String codArt;
	private String descrizione;
	private String um;
	private int pzcart;
	private double peso;
	private double prezzo;
}
