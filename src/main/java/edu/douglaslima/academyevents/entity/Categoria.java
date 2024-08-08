package edu.douglaslima.academyevents.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id")
	private Integer id;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@OneToMany(mappedBy = "categoria")
	private Set<Atividade> atividades = new HashSet<>();
	
	public Categoria() {}

	public Categoria(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
		if (!(obj instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Set<Atividade> getAtividades() {
		return atividades;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
