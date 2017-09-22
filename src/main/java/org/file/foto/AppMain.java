package org.file.foto;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.file.foto.rotas.Rotas;
import org.file.foto.utils.AppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
		
		Diretorio();
	}
	
	
	/*
	 * Cria dois diretorios para a pasta Dados2 e para a pasta Dados
	 */
	public static void Diretorio(){
		
		Rotas rotas = new Rotas();
		Path path1 = Paths.get(rotas.getPasta1());
		Path path2 = Paths.get(rotas.getPasta2());
		
		
		try {
			//Se não existir o diretorio sera criado as pastas
			if(Files.notExists(path1))
			Files.createDirectory(path1);
			
			if(Files.notExists(path2))
				Files.createDirectory(path2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
