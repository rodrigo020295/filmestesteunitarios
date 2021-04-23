package br.com.treino.filmes.service;

import org.springframework.stereotype.Service;

import br.com.treino.filmes.model.Filme;


@Service
public class FilmeService {

	
	public Filme obterFilme(Long codigo) {
		
		if (codigo > 100) {
			return null;
			
		}
		
		return new Filme(
				);
		
				
	}
	
	
}
