package com.artur.riprova.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="BARCODE")
public class Barcode {
	@Id
	@Column(name="barcode")
	private String barcode;
	
	@ManyToOne
	@JoinColumn(name="codart",referencedColumnName="codArt") // permette il join su chiavi esterne => (name=>nome tabella, ref=>nome variabile nell'entità jpa)
	private Articoli articolo;
	
	@Column(name="idtipoart")
	private String idTipoArt;
}
