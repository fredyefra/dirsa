package br.com.dirsa.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import br.com.dirsa.model.Especialidade;
import br.com.dirsa.service.bean.IComboBoxService;

@ManagedBean
public class EspecialidadeConverter implements Converter {

	@Inject
	private IComboBoxService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Especialidade result = null;

		if (value != null) {
			Integer id = new Integer(value);
			result = service.findEspecialidade(id);
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Especialidade model = (Especialidade) value;
			return model.getIdEspecialidade() == null ? null : model.getIdEspecialidade().toString();
		}
		return "";
	}
}