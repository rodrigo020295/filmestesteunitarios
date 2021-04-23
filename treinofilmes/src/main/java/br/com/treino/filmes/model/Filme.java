package br.com.treino.filmes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Filme {

	
	private Long codigo;
	private String titulo;
	private String descricao;
	
	
}
