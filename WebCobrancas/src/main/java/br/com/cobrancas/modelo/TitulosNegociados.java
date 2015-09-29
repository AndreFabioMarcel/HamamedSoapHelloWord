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

@Entity(name = "TITULOS_NEGOCIADOS")
public class TitulosNegociados implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_TITULO", nullable = false)
    private Titulos titulo;
    
    @ManyToOne
    @JoinColumn(name = "ID_NEGOCIACAO", nullable = false)
    private Negociacoes negociacao;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    private void setTitulo(Titulos titulo) {
        this.titulo = titulo;
    }

    public Negociacoes getNegociacao() {
        return negociacao;
    }

    private void setNegociacao(Negociacoes negociacao) {
        this.negociacao = negociacao;
    }
    
    public static class Builder extends AbstractBuilder<TitulosNegociados, Builder> {

        private Builder(TitulosNegociados tituloNegociados) {
            super(tituloNegociados);
        }

        public static Builder create() {
            return new Builder(new TitulosNegociados());
        }

        public static Builder from(TitulosNegociados tituloNegociados) {
            return new Builder(tituloNegociados);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder titulo(Titulos titulo) {
            entity.setTitulo(titulo);
            return this;
        }
        
        public Builder negociacao(Negociacoes negociacao) {
            entity.setNegociacao(negociacao);
            return this;
        }
    }
}