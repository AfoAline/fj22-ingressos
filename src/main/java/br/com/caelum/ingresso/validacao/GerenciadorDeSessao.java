package br.com.caelum.ingresso.validacao;

import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
		
	}
	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova){
		boolean novaTerminaAntesDaExistente = sessaoNova.getHorarioTermino().isBefore(sessaoExistente.getHorario());
		boolean novaComecaDepoisExistente = sessaoNova.getHorario().isAfter(sessaoExistente.getHorarioTermino());
		
		if (novaTerminaAntesDaExistente || novaComecaDepoisExistente){
			return false;
		}
		return true;
	}

	public boolean cabe(Sessao sessaNova){
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaNova));
	}


}
