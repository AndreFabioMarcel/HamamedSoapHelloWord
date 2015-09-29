package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "ESTADOS")
public class Estados implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "SIGLA")
    private String sigla;

    @NotNull
    @Column(name = "NOME")
    private String nome;

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

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    private void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public static class Builder extends AbstractBuilder<Estados, Builder> {

        private Builder(Estados estado) {
            super(estado);
        }

        public static Builder create() {
            return new Builder(new Estados());
        }

        public static Builder from(Estados estado) {
            return new Builder(estado);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder sigla(String sigla) {
            entity.setSigla(sigla);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }
    }
}
