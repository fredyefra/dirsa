package br.com.dirsa.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import br.com.dirsa.model.Equipamento;
import br.com.dirsa.model.Movimentacao;
import br.com.dirsa.model.NomeEquipamento;
import br.com.dirsa.model.OrganizacaoSaudeAeronautica;
import br.com.dirsa.model.StatusEquipamento;
import br.com.dirsa.model.TipoEquipamento;
import br.com.dirsa.model.Usuario;
import br.com.dirsa.service.bean.IComboBoxService;
import br.com.dirsa.service.bean.IConsultarEquipamentoService;
import br.com.dirsa.util.MessageMB;

/**
 * @author frederikfra
 */

@ViewScoped
@Named("consultarEquipamentoMB")
public class ConsultarEquipamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IConsultarEquipamentoService consultarEquipamentoService;
	@Inject
	private IComboBoxService comboBoxService;
	@Inject
	private Equipamento equipamento;
	@Inject
    private Movimentacao movimentacao;
	@Inject
	private StatusEquipamento statusEquipamento;
	@Inject
	private LoginMB loginMB;
	@Inject
	private MessageMB messageMB;
    
	private List<Equipamento> equipamentos;
    private List<OrganizacaoSaudeAeronautica> osasOrigem;
	private List<OrganizacaoSaudeAeronautica> osasAtual;
	private List<NomeEquipamento> nomeEquipamentos;
	private List<TipoEquipamento> tipoEquipamentos;
	private List<StatusEquipamento> statusEquipamentos; 
	
	public ConsultarEquipamentoMB() {
		equipamentos = new ArrayList<Equipamento>();
	}

	@PostConstruct
	public void carregar() {
		equipamentos = consultarEquipamentoService.consultarequipamentos();
		osasOrigem =   comboBoxService.buscarOsas();
	    osasAtual =    comboBoxService.buscarOsas(); 
	    nomeEquipamentos = comboBoxService.buscarNomeEquipamentos();
	    tipoEquipamentos = comboBoxService.buscarTipoEquipamentos(); 
	    statusEquipamentos = comboBoxService.buscarStatusEquipamentos();
	}

	public void carregarDetalhamento(Equipamento equipamento) {
		this.equipamento = consultarEquipamentoService.carregarEquipamento(equipamento.getIdEquipamento());
	}

	public String salvar() {

		if (movimentacao.getIdMovimentacao() == null) {
            
			Usuario usuario = loginMB.getUsuario();
			
			movimentacao.setEquipamento(equipamento);
			movimentacao.setOrganizacaoOrigem(equipamento.getOrganizacaoOrigem());
			movimentacao.setOrganizacaoAtual(equipamento.getOrganizacaoAtual());
			movimentacao.setUsuario(equipamento.getUsuario());
			
			consultarEquipamentoService.salvar(movimentacao);
		    consultarEquipamentoService.statusMovimentar(movimentacao.getEquipamento());
			equipamentos.remove(movimentacao.getEquipamento());
		    
		    messageMB.info("Equipamento Movimentado!");
		  
		    return "sucess";
		}
	
	   return null;
	}

	public void postProcessXLS(Object document) {  
	    HSSFWorkbook wb = (HSSFWorkbook) document;  
	    HSSFSheet sheet = wb.getSheetAt(0);  
	    HSSFRow header = sheet.getRow(0);  

	    HSSFCellStyle cellStyle = wb.createCellStyle();    
	    cellStyle.setFillForegroundColor(HSSFColor.BROWN.index);  
	    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  

	    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
	        HSSFCell cell = header.getCell(i);  

	        cell.setCellStyle(cellStyle);  
	    }  
	}  
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public List<OrganizacaoSaudeAeronautica> getOsasOrigem() {
		return osasOrigem;
	}

	public void setOsasOrigem(List<OrganizacaoSaudeAeronautica> osasOrigem) {
		this.osasOrigem = osasOrigem;
	}

	public List<OrganizacaoSaudeAeronautica> getOsasAtual() {
		return osasAtual;
	}

	public void setOsasAtual(List<OrganizacaoSaudeAeronautica> osasAtual) {
		this.osasAtual = osasAtual;
	}

	public List<NomeEquipamento> getNomeEquipamentos() {
		return nomeEquipamentos;
	}

	public void setNomeEquipamentos(List<NomeEquipamento> nomeEquipamentos) {
		this.nomeEquipamentos = nomeEquipamentos;
	}

	public List<TipoEquipamento> getTipoEquipamentos() {
		return tipoEquipamentos;
	}

	public void setTipoEquipamentos(List<TipoEquipamento> tipoEquipamentos) {
		this.tipoEquipamentos = tipoEquipamentos;
	}

	public List<StatusEquipamento> getStatusEquipamentos() {
		return statusEquipamentos;
	}

	public void setStatusEquipamentos(List<StatusEquipamento> statusEquipamentos) {
		this.statusEquipamentos = statusEquipamentos;
	}

	public StatusEquipamento getStatusEquipamento() {
		return statusEquipamento;
	}

	public void setStatusEquipamento(StatusEquipamento statusEquipamento) {
		this.statusEquipamento = statusEquipamento;
	}
}