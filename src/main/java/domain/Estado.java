package domain;

import jakarta.persistence.*;

@Entity
@Table(
		name = "TB_ESTADO",
		uniqueConstraints = @UniqueConstraint(name = "UK_NM_ESTADO", columnNames = "NM_ESTADO")
)
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
	@SequenceGenerator(name = "SQ_ESTADO", sequenceName = "SQ_ESTADO")
	@Column(name = "ID_ESTADO")
	private int id;

	@Column(name = "NM_ESTADO")
	private String nome;

	@Column(name = "SG_ESTADO")
	private String sigla;

	public Estado() {
	}

	public Estado(int id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public int getId() {
		return id;
	}

	public Estado setId(int id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Estado setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSigla() {
		return sigla;
	}

	public Estado setSigla(String sigla) {
		this.sigla = sigla;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Estado{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", sigla='").append(sigla).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
