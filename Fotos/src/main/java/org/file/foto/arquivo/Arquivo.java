package org.file.foto.arquivo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.file.foto.utils.BaseEntity;
@Entity
@Table(name = "tb_arquivo")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Arquivo extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@Column(name = "tb_arquivo")
	private String nome;

	public Arquivo() {
	
	}

	public Arquivo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
