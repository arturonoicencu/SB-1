package com.artur.riprova.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name="INGREDIENTI")
public class Ingredienti {
	
	@Id
	@Column(name="CODART")
	private String codArt;
	
	@Column(name="INFO")
	private String info;
	
	@OneToOne
	@PrimaryKeyJoinColumn // se due entita padre e figlia hanno la stessa pk, allora associazione Uno a Uno, uso allora PrimaryKeyJoinColumn
	private Articoli articolo;
}
