package com.artur.riprova.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.artur.riprova.dtos.ArticoliDto;
import com.artur.riprova.dtos.BarcodeDto;
import com.artur.riprova.entities.Articoli;
import com.artur.riprova.entities.Barcode;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);

		modelMapper.addMappings(new PropertyMap<Barcode, BarcodeDto>() {
			@Override
			protected void configure() {
				map().setIdTipoArt(source.getIdTipoArt());
			}
		});


		modelMapper.addMappings(new PropertyMap<Articoli, ArticoliDto>() {
			@Override
			protected void configure() {
				
				using(context -> {
					@SuppressWarnings("unchecked")
					Set<Barcode> barcodes = (Set<Barcode>) context.getSource();
					return new HashSet<>(barcodes);
				}).map(source.getBarcode(), destination.getBarcode());
				
				map().setDataCreaz(source.getDataCreaz());
			}
		});

		return modelMapper;
	}
}