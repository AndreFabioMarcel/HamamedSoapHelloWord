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

@Entity(name = "ENDERECOS")
public class Enderecos implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CEP")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = true)
    private Estados estado;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE", nullable = true)
    private Cidades cidade;

    @ManyToOne
    @JoinColumn(name = "ID_BAIRRO", nullable = true)
    private Bairros bairro;

    @ManyToOne
    @JoinColumn(name = "ID_LOGRADOURO", nullable = true)
    private Logradouros logradouro;

    @Override
    public Long getId() {
        return this.id;
    }

    public String getCep() {
        return cep;
    }

    private void setCep(String cep) {
        this.cep = cep;
    }

    public Logradouros getLogradouros() {
        return logradouro;
    }

    private void setLogradouro(Logradouros logradouro) {
        this.logradouro = logradouro;
    }

    public Bairros getBairros() {
        return bairro;
    }

    private void setBairro(Bairros bairro) {
        this.bairro = bairro;
    }

    public Estados getEstado() {
        return estado;
    }

    private void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Cidades getCidade() {
        return cidade;
    }

    private void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public static class Builder extends AbstractBuilder<Enderecos, Builder> {

        private Builder(Enderecos endereco) {
            super(endereco);
        }

        public static Builder create() {
            return new Builder(new Enderecos());
        }

        public static Builder from(Enderecos endereco) {
            return new Builder(endereco);
        }

        public Builder cep(String cep) {
            entity.setCep(cep);
            return this;
        }

        public Builder estado(Estados estado) {
            entity.setEstado(estado);
            return this;
        }

        public Builder cidade(Cidades cidade) {
            entity.setCidade(cidade);
            return this;
        }

        public Builder bairro(Bairros bairro) {
            entity.setBairro(bairro);
            return this;
        }

        public Builder logradouro(Logradouros logradouro) {
            entity.setLogradouro(logradouro);
            return this;
        }
    }
}
