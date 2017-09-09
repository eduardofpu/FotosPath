package org.file.foto.file3;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.file.foto.utils.BaseEntity;
import org.hibernate.validator.constraints.br.CPF;
import org.jboss.logging.annotations.Message;
@Entity
@Table(name = "tb_Fotos3")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class File3 extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "tb_file3",  nullable = true)
	byte[] file3;

	@Column(name = "tb_nome_Image", length = 80, nullable = true)
	String nomeImage;
	@NotNull(message = "Campo usuário não pode estar em branco")
	@Column(name = "tb_usuario", length = 80, nullable = false)
	String usuario;
	@CPF(message="CPF inválido.")	
	@Column(name = "cpf_funcionario", length = 255, nullable = false, unique = true)
	private String cpf;


	public File3() {
		super();
		// TODO Auto-generated constructor stub
	}


	public File3(byte[] file3, String nomeImage, String usuario, String cpf) {
		super();
		this.file3 = file3;
		this.nomeImage = nomeImage;
		this.usuario = usuario;
		this.cpf = cpf;
	}


	public byte[] getFile3() {
		return file3;
	}


	public void setFile3(byte[] file3) {
		this.file3 = file3;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
