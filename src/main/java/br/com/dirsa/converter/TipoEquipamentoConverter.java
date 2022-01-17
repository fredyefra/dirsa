package br.com.dirsa.converter;


import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import br.com.dirsa.model.TipoEquipamento;
import br.com.dirsa.service.bean.IComboBoxService;

@ManagedBean
public class TipoEquipamentoConverter implements Converter {

	@Inject
	private IComboBoxService service; 
	
    @Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
    	TipoEquipamento result = null;
    	
    	if (value != null) {
			Integer id = new Integer(value);
		    result = service.findTipoEquipamento(id);
    	}
    	return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			TipoEquipamento model = (TipoEquipamento) value;
		    return model.getIdTipoEquipamento() == null ? null : model.getIdTipoEquipamento().toString(); 
		}
		return "";
	}
}