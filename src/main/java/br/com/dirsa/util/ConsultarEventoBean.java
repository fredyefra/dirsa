package br.com.dirsa.util;

import java.io.Serializable;

import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("consultarEventoBean")
public class ConsultarEventoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Character escolha;
	private String focus;
	
	/**
	 * Metodo que verifica o radio e habilita o input - tipo char
	 */
	public ValueChangeEvent verificaRadioInputChar(ValueChangeEvent event){
		
		setEscolha((Character)event.getNewValue());
		verificaFocusEquipamento();
		return event;		
	}

	private void verificaFocusEquipamento(){
		switch(this.escolha){
			case '0':
				this.focus = new String("aluno");
				break;
			case '1':
				this.focus = new String("atendente");
				break;
			case '2':
				this.focus = new String("livro");	
				break;
			case '3':
				this.focus = new String("lotacao");
				break;
			case '4':
				this.focus = new String("regiao");
				break;
		}
		
	}
	
	
	/**

	 * Metodo que verifica o radio e habilita o input - tipo char
	 */
	public ValueChangeEvent verificaRadioInputCharListaFicha(ValueChangeEvent event){
		
		setEscolha((Character)event.getNewValue());
		verificaFocusListaFicha();
		return event;		
	}
	
	private void verificaFocusListaFicha(){
		switch(this.escolha){
			case '1':
				this.focus = new String("exercicio");
				break;
			case '2':
				this.focus = new String("lotacao");
				break;
			case '3':
				this.focus = new String("selectRegiao");	
				break;
			case '4':
				this.focus = new String("cargo");
				break;
			case '5':
				this.focus = new String("porteArma");
				break;
			case '6':
				this.focus = new String("sitFicha");
				break;
		}
		
	}
	
	/**
	 * Metodo que verifica o radio

	 * Metodo que verifica o radio e habilita o input - tipo char

	 */
	public ValueChangeEvent verificaRadioInputFicha(ValueChangeEvent event){
		setEscolha((Character)event.getNewValue());
		verificaFocusFicha();
		return event;		
	}
	
	/**
	 * Metodo que verifica qual opcao na tela foi selecionada
	 */
	private void verificaFocusFicha(){
		switch(this.escolha){
			case '1':
				this.focus = new String("cpf");
				break;
			case '2':
				this.focus = new String("matSiape");
				break;
			case '3':
				this.focus = new String("nome");
				break;	
		}
	}

	
	
	//	
//	/**
//	 * Metodo que verifica o radio
//	 */
//	public ValueChangeEvent verificaRadioCargo(ValueChangeEvent event){
//		
//		setEscolha((Character)event.getNewValue());
//		verificaFocusCargo();
//		return event;		
//	}
//	
//	/**
//	 * verifica o cargo do servidor
//	 */
//	private void verificaFocusCargo(){
//		switch(this.escolha){
//			case '1':
//				this.focus = new String("auditor");
//				break;
//			case '2':
//				this.focus = new String("analista");
//				break;
//		}
//		
//	}

	public Character getEscolha() {
		return escolha;
	}

	public void setEscolha(Character escolha) {
		this.escolha = escolha;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}
}