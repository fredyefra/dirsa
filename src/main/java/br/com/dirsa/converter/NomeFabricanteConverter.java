package br.com.dirsa.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import br.com.dirsa.model.NomeFabricante;
import br.com.dirsa.service.bean.IComboBoxService;

@ManagedBean
public class NomeFabricanteConverter implements Converter {

	@Inject
	private IComboBoxService service; 
	
    @Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
    	NomeFabricante result = null;
    	
    	if (value != null) {
			Integer id = new Integer(value);
		    result = service.findNomeFabricante(id);
    	}
    	return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			NomeFabricante model = (NomeFabricante) value;
		    return model.getIdFabricante() == null ? null : model.getIdFabricante().toString(); 
		}
		return "";
	}
}