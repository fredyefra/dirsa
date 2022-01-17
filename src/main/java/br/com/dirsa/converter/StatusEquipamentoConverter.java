package br.com.dirsa.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import br.com.dirsa.model.StatusEquipamento;
import br.com.dirsa.service.bean.IComboBoxService;

@ManagedBean
public class StatusEquipamentoConverter implements Converter {

	@Inject
	private IComboBoxService service; 
	
    @Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
    	StatusEquipamento result = null;
    	
    	if (value != null) {
			Integer id = new Integer(value);
		    result = service.findStatusEquipamento(id);
    	}
    	return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			StatusEquipamento model = (StatusEquipamento) value;
		    return model.getIdStatus() == null ? null : model.getIdStatus().toString(); 
		}
		return "";
	}
}
