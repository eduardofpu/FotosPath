package org.file.foto.file2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.file.foto.utils.BaseEntity;
@Entity
@Table(name = "tb_Fotos2")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class File2 extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	//@Lob
	//@Column(name = "tb_file2",  nullable = true)
	//byte[] file2;
	
	@Column(name="tb_foto", columnDefinition="text")
	private String file2;

	@Column(name="tb_nome_image")
	 private String nomeImage;

	
	@NotNull(message = "Digite um nome")
	@Column(name = "tb_usuario", length = 80,nullable = false)
	private String usuario;

	
	
	public File2() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	

	public File2(String file2, String nomeImage, String usuario) {
		super();
		this.file2 = file2;
		this.nomeImage = nomeImage;
		this.usuario = usuario;
	}



	public String getFile2() {
		return file2;
	}



	public void setFile2(String file2) {
		this.file2 = file2;
	}


	public String getNomeImage() {
		return nomeImage;
	}

	public void setNomeImage(String nomeImage) {
		this.nomeImage = nomeImage;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}

}
