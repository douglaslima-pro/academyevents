package edu.douglaslima.academyevents.entity;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_bloco", uniqueConstraints = @UniqueConstraint(columnNames = {"inicio", "fim"}))
public class Bloco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bloco_id")
	private Integer id;
	private Instant inicio;
	private Instant fim;
	@ManyToOne
	@JoinColumn(name = "atividade_id", referencedColumnName = "atividade_id")
	private Atividade atividade;
	
	public Bloco() {}

	public Bloco(Integer id, Instant inicio, Instant fim) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
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
		if (!(obj instanceof Bloco)) {
			return false;
		}
		Bloco other = (Bloco) obj;
		return Objects.equals(id, other.id);
	}
	
	public Integer getId() {
		return id;
	}

	public Instant getInicio() {
		return inicio;
	}

	public Instant getFim() {
		return fim;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public void setFim(Instant fim) {
		this.fim = fim;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}
