package org.file.foto.arquivo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.file.foto.utils.BaseBean;
@XmlRootElement
public class RespLista extends BaseBean{
	
	private static final long serialVersionUID = 1L;
	private String lista;

	public RespLista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RespLista(List<String> lista) {
		super();
		this.lista = lista.toString();
		for(String l:lista){
			System.out.println(l);
		}
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}
	
	

}
