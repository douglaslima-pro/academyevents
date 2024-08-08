package edu.douglaslima.academyevents.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atividade_id")
	private Integer id;
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(columnDefinition = "TEXT NOT NULL")
	private String descricao;
	@Column(nullable = false)
	private Double preco;
	@ManyToMany(mappedBy = "atividades")
	private Set<Participante> participantes = new HashSet<>();
	@OneToMany(mappedBy = "atividade")
	private Set<Bloco> blocos = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
	private Categoria categoria;
	
	public Atividade() {}

	public Atividade(Integer id, String nome, String descricao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Atividade)) {
			return false;
		}
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}
	
	public Set<Participante> getParticipantes() {
		return participantes;
	}
	
	public Set<Bloco> getBlocos() {
		return blocos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
