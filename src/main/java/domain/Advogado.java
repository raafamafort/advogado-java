package domain;

import jakarta.persistence.*;

@Entity
@Table(
        name = "TB_ADVOGADO",
        uniqueConstraints = @UniqueConstraint(name = "UK_NUM_OAB", columnNames = "NUM_OAB")
)
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ADVOGADO")
    @SequenceGenerator(name = "SQ_ADVOGADO", sequenceName = "SQ_ADVOGADO")
    @Column(name = "ID_ADVOGADO")
    private long id;

    @Column(name = "NM_ADVOGADO")
    private String nome;

    @Column(name = "NUM_OAB")
    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(
            name = "ID_ESTADO",
            referencedColumnName = "ID_ESTADO",
            foreignKey = @ForeignKey(
                    name = "FK_ESTADO",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Estado estado;

    public Advogado() {
    }

    public Advogado(long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public Advogado setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Advogado{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", numeroOAB='").append(numeroOAB).append('\'');
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }


}
