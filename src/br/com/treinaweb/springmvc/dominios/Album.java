package br.com.treinaweb.springmvc.dominios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//CLASSE POJO
@Entity
@Table(name="alb_albuns")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="alb_id")
	private Long id;
	
	//Anota��es fornecidas pela validation-api e hibernate validator declarados no pom.xml e no servlet
	
	@NotNull(message = "O nome � obrigat�rio")
	@NotEmpty(message = "O nome � obrigat�rio")
	@Size(min = 4, max = 10, message = "O nome do �lbum deve conter entre 4 e 10 caracteres")
	@Column(name="alb_nome", length = 10, nullable = false)
	private String nome;
	
	@NotNull(message = "O ano de lan�amento � obrigat�rio")
	@Min(value = 1990, message = "O ano de lan�amento deve ser a partir de 1990")
	@Max(value = 2030, message = "O ano de lan�amento deve ser at� 2030")
	@Column(name="alb_ano_lancamento", nullable = false)
	private int anoDeLancamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anosDeLancamento) {
		this.anoDeLancamento = anosDeLancamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
