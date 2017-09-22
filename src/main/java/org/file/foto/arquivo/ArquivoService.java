package org.file.foto.arquivo;

import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.ARQUIVO_PATH)
public class ArquivoService extends GenericService<Arquivo,Long>{

	
	public Arquivo insert(@RequestBody Arquivo arquivo){
	Diretorio diretorio = new Diretorio();
	
	String dados = arquivo.getNome();
	
	diretorio.AbrirArquivo(dados);	
		
		
	return super.insert(arquivo);	
	}
}
