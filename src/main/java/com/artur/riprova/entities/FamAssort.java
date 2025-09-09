package com.artur.riprova.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="FAMASSORT")
public class FamAssort {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DESCRIZIONE")
	private String descrizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "famAssort")
	private Set<Articoli> articolo = new HashSet<>();
}
