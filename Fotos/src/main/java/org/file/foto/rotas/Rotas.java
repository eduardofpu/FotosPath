package org.file.foto.rotas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.file.foto.file.File1;
import org.file.foto.file.FileRepository;
import org.file.foto.file2.File2;
import org.springframework.beans.factory.annotation.Autowired;

public class Rotas {

	// Abre o caminho da pasta imagens
	String buscarImagens = "C:\\Users\\Eduardo\\Pictures\\ImagesParaTestarSistema\\Usuario\\";

	// Referencia o caminho da pasta Dados
	String pasta1 = "Dados/";

	// Referencia o caminho da pasta Dados2
	String pasta2 = "src\\main\\webapp\\Dados2/";

	Path abrirFile1;
	Path abrirFile2;
	Boolean deletarFile1;
	Boolean deletarFile2;

	/*
	 * Concatena o nome da imagem com a data, hora, minuto e segundos na classe
	 * File1
	 */
	public String getFile1Concate(File1 file) {

		String data = file.getDateTime();
		String nomeFile = file.getNomeImage();
		String datanomefile = data.concat(nomeFile);

		String aux;

		aux = datanomefile;
		datanomefile = nomeFile;
		nomeFile = aux;

		return aux;
	}

	/*
	 * Concatena o nome da imagem com a data, hora, minuto e segundos na classe
	 * File2
	 */
	public String getFile2Concate(File2 file) {

		String data = file.getDateTime();
		String nomeFile = file.getNomeImage();
		String datanomefile = data.concat(nomeFile);

		String aux;

		aux = datanomefile;
		datanomefile = nomeFile;
		nomeFile = aux;

		return aux;
	}

	/*
	 * retorna a pasta input file para escolher a imagem
	 */
	public String getBuscarImagens() {
		return buscarImagens;
	}

	public Path getAbrirFile1(File1 file) {

		return Paths.get(getBuscarImagens() + file.getNomeImage());
	}

	public Path getAbrirFile2(File2 file) {

		return Paths.get(getBuscarImagens() + file.getNomeImage());
	}

	/*
	 * retorna a pasta Dados
	 */
	public String getPasta1() {
		return pasta1;
	}

	/*
	 * retorna a pasta Dados2
	 */
	public String getPasta2() {
		return pasta2;
	}

	public Boolean getDeletarFile1(File1 file) {
		return (new File(getPasta2() + file.getNomeImage())).delete();
	}

	public void detarArquivoPasta1(File1 file) {

		if (getDeletarFile1(file)) {

			System.out.println("Imagem deletada do diretorio com sucesso!");

		} else {

			System.out.println("Falha na remoção da imagem no diretorio");
		}
	}

	public Boolean getDeletarFile2(File2 file) {
		return (new File(getPasta2() + file.getNomeImage())).delete();
	}

	public void detarArquivoPasta2(File2 file) {

		if (getDeletarFile2(file)) {

			System.out.println("Imagem deletada do diretorio com sucesso!");

		} else {

			System.out.println("Falha na remoção da imagem no diretorio");
		}
	}

	public void salvarArquivoPasta1(File1 file) {

		// Converte a imagem em array de byte e salva na pasta Dados2
		try (BufferedInputStream lerArquivo = new BufferedInputStream(new FileInputStream("" + getAbrirFile1(file)));
				BufferedOutputStream fileGravar = new BufferedOutputStream(
						new FileOutputStream(getPasta2() + getFile1Concate(file)), 4098)) {

			int leitura;

			while ((leitura = lerArquivo.read()) != -1) {
				byte c = (byte) leitura;
				fileGravar.write(c);
				// System.out.println("Bytes : "+c);
			}

			fileGravar.flush();

			System.out.println("Dados gravados no diretorio com sucesso!");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Não foi possivel gravar os dados no diretorio");
		}

		file.setNomeImage(getFile1Concate(file));

	}

	public void salvarArquivoPasta2(File2 file) {

		// Converte a imagem em array de byte e salva na pasta Dados
		try (BufferedInputStream lerArquivo = new BufferedInputStream(new FileInputStream("" + getAbrirFile2(file)));
				BufferedOutputStream fileGravar = new BufferedOutputStream(
						new FileOutputStream(getPasta1() + getFile2Concate(file)), 4098)) {

			int leitura;

			while ((leitura = lerArquivo.read()) != -1) {
				byte c = (byte) leitura;
				fileGravar.write(c);
				// System.out.println("Bytes : "+c);
			}

			fileGravar.flush();

			System.out.println("Dados gravados no diretorio com sucesso!");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Não foi possivel gravar os dados no diretorio");
		}

		file.setNomeImage(getFile2Concate(file));

	}

	public void alterarArquivoPasta1(File1 file) {

		// Converte a imagem em array de byte e salva na pasta Dados2
		try (BufferedInputStream lerArquivo = new BufferedInputStream(new FileInputStream("" + getAbrirFile1(file)));
				BufferedOutputStream fileGravar = new BufferedOutputStream(
						new FileOutputStream(getPasta2() + getFile1Concate(file)), 4098)) {

			int leitura;

			while ((leitura = lerArquivo.read()) != -1) {
				byte c = (byte) leitura;
				fileGravar.write(c);
				// System.out.println("Bytes : "+c);
			}

			fileGravar.flush();

			System.out.println("Dados atualizados no diretorio com sucesso!");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Não foi possivel atualizar os dados no diretorio");
		}

		file.setNomeImage(getFile1Concate(file));

	}

	public void alterarArquivoPasta2(File2 file) {

		// Converte a imagem em array de byte e salva na pasta Dados
		try (BufferedInputStream lerArquivo = new BufferedInputStream(new FileInputStream("" + getAbrirFile2(file)));
				BufferedOutputStream fileGravar = new BufferedOutputStream(
						new FileOutputStream(getPasta1() + getFile2Concate(file)), 4098)) {

			int leitura;

			while ((leitura = lerArquivo.read()) != -1) {
				byte c = (byte) leitura;
				fileGravar.write(c);
				// System.out.println("Bytes : "+c);
			}

			fileGravar.flush();

			System.out.println("Dados atualizados no diretorio com sucesso!");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Não foi possivel atualizar os dados no diretorio");
		}

		file.setNomeImage(getFile2Concate(file));
	}

}
