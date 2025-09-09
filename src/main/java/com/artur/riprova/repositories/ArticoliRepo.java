package com.artur.riprova.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artur.riprova.entities.Articoli;

public interface ArticoliRepo extends JpaRepository<Articoli,Long> {
	
	Articoli findByCodArt(String codArt);
	
	List<Articoli> findByDescrizioneLike(String descrizione,Pageable pageable);
	
	List<Articoli> findByCodStatOrderByDescrizione(String codStat);
	
	@Query(value="SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)") // JPQL
	Articoli selectByEan(@Param("ean") String ean);
	
	@Query(value="SELECT COUNT(*) FROM articoli WHERE descrizione LIKE :desArt",nativeQuery=true) // SQL, native=true
	int countRecords(@Param("desArt") String descrizione);
}
