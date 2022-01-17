package br.com.dirsa.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import br.com.dirsa.model.PostoGraduacao;
import br.com.dirsa.service.bean.IComboBoxService;

@ManagedBean
public class PostoGraduacaoConverter implements Converter  {
   
	@Inject
	private IComboBoxService service; 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
    	PostoGraduacao result = null;
    	
    	if (value != null) {
			Integer id = new Integer(value);
		    result = service.findPostoGraduacao(id);
    	}
    	return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			PostoGraduacao model = (PostoGraduacao) value;
		    return model.getIdPostoGraduacao() == null ? null : model.getIdPostoGraduacao().toString(); 
		}
		return "";
	}
}