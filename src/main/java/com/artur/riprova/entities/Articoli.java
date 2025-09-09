package com.artur.riprova.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*mappedBy => nome attributo nel modello figlio
 * fetchType => 
 * 	LAZY:associazione caricata solo quando vi ci si accede e non subito appena si recupera l'entita principale dal db
 *  EAGER: associazioni caricate anche in caso non sia necessario momentaneamente l'accesso, consigliata solo per entita la quale associazione sarà SEMPRE necessaria
 * cascade => propaga le operazioni di modifica anche nelle entità figlia
 *  ALL: propagazione di tutte le operazioni di persistenza(inserimento,aggiornamento,eliminazione)
 *  PERSIST: propagazione operazione di persistenza inserimentoi
 *  MERGE: propagazione dell operazione di aggiornamento
 *  REMOVE: propagazione dell operazione di rimozione
 *  REFRESH: operazione di ricaricamento (refresh)
 *  DETACH: operazione di distacco del padre dal figlio
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ARTICOLI") // se nome classe = nome tabella, si puo omettere questo decoratore
public class Articoli {
	@Id
	@Column(name="codart")
	private String codArt;

	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="um")
	private String um;
	
	@Column(name="codstat")
	private String codStat;
	
	@Column(name="pzcart")
	private Integer pzcart;
	
	@Column(name="pesonetto")
	private double pesoNetto;
	
	
	@Column(name="idstatoart")
	private String idStatoArt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datacreazione")
	private Date dataCreaz;
	

	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL,mappedBy="articolo",orphanRemoval=true)
	private Set<Barcode> barcode = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="articolo",orphanRemoval=true)
	private Ingredienti ingredienti;
	
	@ManyToOne
	@JoinColumn(name="idiva",referencedColumnName = "idIva")
	private IVA iva;
	
	@ManyToOne
	@JoinColumn(name="idfamass",referencedColumnName="id")
	private FamAssort famAssort;

}
