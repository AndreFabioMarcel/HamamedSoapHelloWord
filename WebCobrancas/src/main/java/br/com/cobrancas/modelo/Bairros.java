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

@Entity(name = "BAIRROS")
public class Bairros implements AbstractEntityId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "NOME")
    private String nome;
        
    @ManyToOne
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    private Cidades cidade;
       
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Cidades getCidade() {
        return cidade;
    }

    private void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    
    public static class Builder extends AbstractBuilder<Bairros, Builder> {

        private Builder(Bairros bairro) {
            super(bairro);
        }

        public static Builder create() {
            return new Builder(new Bairros());
        }

        public static Builder from(Bairros bairro) {
            return new Builder(bairro);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }
        
        public Builder cidade(Cidades cidade) {
            entity.setCidade(cidade);
            return this;
        }
    } 
}
