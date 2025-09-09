package com.artur.riprova.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.artur.riprova.dtos.ArticoliDto;
import com.artur.riprova.entities.Articoli;
import com.artur.riprova.repositories.ArticoliRepo;
import org.springframework.data.domain.Pageable;

@Service
public class ArticoliServiceImpl implements ArticoliService{

	//dependency injection , permette di lasciare la gestione degli oggetti all' IoC ,il container di SpringBoot
	ArticoliRepo articoliRepo;
	private ModelMapper modelMapper;
	
	public ArticoliServiceImpl(ArticoliRepo artRepo,ModelMapper mm) {
		this.articoliRepo = artRepo;
		this.modelMapper = mm;
	}
	
	@Override
	public List<ArticoliDto> SelAll() {
		return ConvertToDto(articoliRepo.findAll());
	}

	@Override
	public ArticoliDto SelByCodArt(String codart) {
		return ConvertToDto(articoliRepo.findByCodArt(codart));
	}

	@Override
	public List<ArticoliDto> SelByDescrizione(String filter, int page, int numrec) {
		filter = "%".concat(filter.toUpperCase().concat("%")); // carattere jolly, in modo da ottenere un filtro del tipo: like %FILTRO%
		Pageable pageAndRecords = PageRequest.of(page, numrec);
		
		return ConvertToDto(articoliRepo.findByDescrizioneLike(filter, pageAndRecords));
	}

	@Override
	public ArticoliDto SelByBarcode(String barcode) {
		return ConvertToDto(articoliRepo.selectByEan(barcode));
	}
	
	@SuppressWarnings("unused")
	public ArticoliDto ConvertToDto(Articoli articoli) {
		ArticoliDto dto = null;
		
		if(dto != null) dto = modelMapper.map(articoli, ArticoliDto.class);
		return dto;
	}
	
	private List<ArticoliDto> ConvertToDto(List<Articoli> articoli){
		List<ArticoliDto> dto = articoli
				.stream()
				.map(source -> modelMapper.map(source,ArticoliDto.class))
				.collect(Collectors.toList());
		
		return dto;
	}

	@Override
	public int NumRecords(String filter) {
		
		return articoliRepo.countRecords(filter);
	}
	


}
