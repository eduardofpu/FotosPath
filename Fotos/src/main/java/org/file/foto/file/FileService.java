package org.file.foto.file;


import java.io.File;

import javax.servlet.http.HttpSession;

import org.file.foto.rotas.Rotas;
import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.FILE_PATH)
public class FileService extends GenericService<File1, Long> {

	@Autowired
	FileRepository repositorio;
	Rotas rotas = new Rotas();

	/*
	 * (non-Javadoc) Inserir imagens na pasta Dados2
	 */
	@Override
	public File1 insert(@RequestBody File1 file) {
		
						
        //salva a imagem na Dados2
		rotas.salvarArquivoPasta1(file);        
		//salva o nome da imagem no banco
		return super.insert(file);
	}

	/*
	 * (non-Javadoc) Deletar imagens da pasta Dados2
	 */
	public void delete(@RequestBody File1 file) {
        //deleta a imagem da pasta Dados2
		rotas.detarArquivoPasta1(file);
        //deleta o nome da imagem no banco
		super.delete(file);
	}

	/*
	 * (non-Javadoc) Alterar imagens da pasta Dados2
	 */
	public void update(@RequestBody File1 file) {		

		// SQL busca o nome da imagem atraves do nome do usuario
		File1 nome = repositorio.findByNomeImage(file.getUsuario());
		System.out.println("Usuario = " + file.getUsuario() + "   Nome image =" + nome.getNomeImage());
		Boolean success ;
		
        //Deleta a imagem na pasta Dados2 Se o nome da imagem no banco for igual a imagem da pasta Dados2
		if (success = true) {			
			(new File(rotas.getPasta2() + nome.getNomeImage())).delete();

			System.out.println("Image deletada do diretorio com sucesso!" +nome.getNomeImage());

		} else {

			System.out.println("Falha na remoção da imagem no diretorio");
		}
        //Chama o metodo para salvar a nova imagem na pasta Dados2
		rotas.alterarArquivoPasta1(file);
		//Altera o nome da nova imagem no banco
		super.update(file);
	}

}