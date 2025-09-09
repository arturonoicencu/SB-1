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
@Table(name="IVA")
public class IVA {
	
	@Id
	@Column(name="IDIVA")
	private int idIva;
	
	@Column(name="DESCRIZIONE")
	private String descrizione;
	
	@Column(name="ALIQUOTA")
	private int aliquota;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="")
	private Set<Articoli> articoli = new HashSet<>();
}
