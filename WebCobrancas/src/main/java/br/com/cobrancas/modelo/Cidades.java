package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "CIDADES")
public class Cidades implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private Estados estado;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public static class Builder extends AbstractBuilder<Cidades, Builder> {

        private Builder(Cidades cidade) {
            super(cidade);
        }

        public static Builder create() {
            return new Builder(new Cidades());
        }

        public static Builder from(Cidades cidade) {
            return new Builder(cidade);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder estado(Estados estado) {
            entity.setEstado(estado);
            return this;
        }
    }
}
