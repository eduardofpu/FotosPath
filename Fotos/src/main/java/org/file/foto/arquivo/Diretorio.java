package org.file.foto.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Diretorio {
	Path path = Paths.get("Arquivo");	
	Path txt = Paths.get("Arquivo\\nomes.txt");	
	
	
	public void AbrirArquivo(String nome){
		
		try{
			if(Files.notExists(path)){
				Files.createDirectories(path);
				System.out.println("Diretorio Arquivo criado com sucesso!");	
			}
				
			if(Files.notExists(txt)){
				Files.createFile(txt);
				System.out.println("Arquivo nomes.txt criano com sucesso!");
			}
				
			
			File file = new File("Arquivo\\nomes.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(nome);
			bw.newLine();
			bw.flush();
			bw.close();
						
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public List<String> LerArquivo(List<String>listar) throws IOException{
		
		listar=Files.readAllLines(txt,Charset.defaultCharset());
		
		return listar;
	}

}
