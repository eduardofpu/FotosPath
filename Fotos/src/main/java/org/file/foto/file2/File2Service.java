package org.file.foto.file2;


import java.io.File;
import org.file.foto.rotas.Rotas;
import org.file.foto.utils.GenericService;
import org.file.foto.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.FILE2_PATH)
public class File2Service extends GenericService<File2, Long> {

	@Autowired
	File2Repository repositorio;
	Rotas rotas = new Rotas();

	@Override
	public File2 insert(@RequestBody File2 file) {
		
		//Salva a imagem na pasta Dados e no banco
		rotas.salvarArquivoPasta2(file);
		return super.insert(file);
	}

	public void delete(@RequestBody File2 file) {
        //Deleta a imagem na pasta Dados e no banco
		rotas.detarArquivoPasta2(file);

		super.delete(file);
	}

	public void update(@RequestBody File2 file) {

		// SQL busca o nome da imagem atraves do nome do usuario
		File2 nome = repositorio.findByNomeImage(file.getUsuario());
		System.out.println("Usuario = " + file.getUsuario() + "   Nome image =" + nome.getNomeImage());
		boolean success;
        //Deleta a imagem na pasta Dados se o nome da pasta no banco for igula ao da pasta Dados
		if (success = true) {

			// Ao pegar o nome da imagem ela e comparada na pasta Dados para ser
			// deletada
			success = (new File(rotas.getPasta1() + nome.getNomeImage())).delete();
			System.out.println("Image deletada do diretorio com sucesso! =" + nome.getNomeImage());

		} else {

			System.out.println("Falha na remoção da imagem no diretorio");
		}
		//Insere a nova imagem na pasta Dados
		rotas.alterarArquivoPasta2(file);
        //Altera a nova imagem no banco
		super.insert(file);
	}

}
