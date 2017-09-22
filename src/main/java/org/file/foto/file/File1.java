package org.file.foto.file;

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
@Table(name = "tb_Fotos")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class File1 extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	
	@Column(name="tb_nome_image", length = 255)
	 private String nomeImage;

	
	@NotNull(message = "Digite um nome")
	@Column(name = "tb_usuario", length = 80,nullable = false)
	private String usuario;

	
	

	public File1() {
		super();
		// TODO Auto-generated constructor stub
	}



	public File1(String nomeImage, String usuario) {
		super();
		
		this.nomeImage = nomeImage;
		this.usuario = usuario;
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
