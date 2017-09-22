package org.file.foto.arquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;


@Named
public class ServiceLista implements IMathRestService{

	List<String> listar = new ArrayList<>();
	Diretorio diretorio = new Diretorio();

		
	public RespLista listar() throws IOException {
		return new RespLista(diretorio.LerArquivo(listar));
	}
}
