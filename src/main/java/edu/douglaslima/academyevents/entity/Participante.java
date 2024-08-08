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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_participante")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participante_id")
	private Integer id;
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	@ManyToMany
	@JoinTable(
			name = "tb_participante_atividade",
			joinColumns = @JoinColumn(name = "participante_id", referencedColumnName = "participante_id"),
			inverseJoinColumns = @JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")
			)
	private Set<Atividade> atividades = new HashSet<>();
	
	public Participante() {}

	public Participante(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
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
		if (!(obj instanceof Participante)) {
			return false;
		}
		Participante other = (Participante) obj;
		return Objects.equals(id, other.id);
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	public Set<Atividade> getAtividades() {
		return atividades;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
