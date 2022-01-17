package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dirsa.model.Movimentacao;
import br.com.dirsa.service.bean.IMovimentarEquipamentoService;

@ViewScoped
@Named("movimentacaoMB")
public class MovimentacaoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Movimentacao movimentacao;
	
	private List<Movimentacao> movimentados;
	
	@Inject
	private IMovimentarEquipamentoService movimentarEquipamentoService;

	@PostConstruct
	public void carregar() {
		movimentados = movimentarEquipamentoService.consultarMovimentados();
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public List<Movimentacao> getMovimentados() {
		return movimentados;
	}

	public void setMovimentados(List<Movimentacao> movimentados) {
		this.movimentados = movimentados;
	}
}