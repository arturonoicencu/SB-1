package com.artur.riprova.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.artur.riprova.entities.Articoli;

@Service
public class ArticoliServiceImpl implements ArticoliService{

	
	private static List<Articoli> getArticoli(){
		List<Articoli> art = new ArrayList<>();
		art.add(new Articoli("23508923","Farina","PZ",45,1.2,1.50));
		art.add(new Articoli("23089223","Shampoo","PZ",45,1.2,1.50));
		art.add(new Articoli("23028923","Maizena","PZ",45,1.2,1.50));
		art.add(new Articoli("23018923","Pasta","PZ",45,1.2,1.50));
		
		return art;
		
	}
	
	@Override
	public List<Articoli> getAll() {
		return getArticoli();
	}

}
