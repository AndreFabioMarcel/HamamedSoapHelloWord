package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "DEVEDORES")
public class Devedores implements AbstractEntityId{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "OBSERVACAO")
    private String observacao;

    @NotNull
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
    
    @OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name = "ID_PESSOA", nullable = false)
    private Pessoas pessoa;
    
    @ManyToOne
    @JoinColumn(name = "ID_ENTIDADE", nullable = false)
    private Entidades entidade;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    private void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    private void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    private void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public Entidades getEntidade() {
        return entidade;
    }

    private void setEntidade(Entidades entidade) {
        this.entidade = entidade;
    }
    
    public static class Builder extends AbstractBuilder<Devedores, Builder> {

        private Builder(Devedores devedor) {
            super(devedor);
        }

        public static Builder create() {
            return new Builder(new Devedores());
        }

        public static Builder from(Devedores devedor) {
            return new Builder(devedor);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder observacao(String observacao) {
            entity.setObservacao(observacao);
            return this;
        }
        
        public Builder dataCadastro(LocalDate dataCadastro) {
            entity.setDataCadastro(dataCadastro);
            return this;
        }

        public Builder pessoa(Pessoas pessoa) {
            entity.setPessoa(pessoa);
            return this;
        }
        
        public Builder entidade(Entidades entidade) {
            entity.setEntidade(entidade);
            return this;
        }
    }
}
