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

@Entity(name = "LOGRADOUROS")
public class Logradouros implements AbstractEntityId{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "NOME")
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "ID_BAIRRO", nullable = false)
    private Bairros bairro;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Bairros getBairro() {
        return bairro;
    }

    private void setBairro(Bairros bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    
    public static class Builder extends AbstractBuilder<Logradouros, Builder> {

        private Builder(Logradouros logradouro) {
            super(logradouro);
        }

        public static Builder create() {
            return new Builder(new Logradouros());
        }

        public static Builder from(Logradouros logradouro) {
            return new Builder(logradouro);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }
        
        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }
        
        public Builder bairro(Bairros bairro) {
            entity.setBairro(bairro);
            return this;
        }
    } 
}
