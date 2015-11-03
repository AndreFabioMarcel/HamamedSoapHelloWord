package br.com.cobrancas.modelo;

import br.com.cobrancas.enun.TipoTitulo;
import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "TITULOS")
public class Titulos implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_TITULO")
    private TipoTitulo tipoTitulo;
    
    @Column(name = "NUMERO_TITULO")
    private String numeroTitulo;
    
    @Column(name = "NUMERO_PARCELA")
    private int numeroParcela;
    
    @NotNull
    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;
    
    @Column(name = "VALOR_CARTORIO")
    private Double valorCartorio;
    
    @NotNull
    @Column(name = "VALOR_TITULO")
    private Double valorTitulo;
    
    @ManyToOne
    @JoinColumn(name = "ID_DEVEDOR", nullable = false)
    private Devedores devedor;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public TipoTitulo getTipoTitulo() {
        return tipoTitulo;
    }

    private void setTipoTitulo(TipoTitulo tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    private void setNumeroTitulo(String numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    private void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    private void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorCartorio() {
        return valorCartorio;
    }

    private void setValorCartorio(Double valorCartorio) {
        this.valorCartorio = valorCartorio;
    }

    public Double getValorTitulo() {
        return valorTitulo;
    }

    private void setValorTitulo(Double valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public Devedores getDevedor() {
        return devedor;
    }

    private void setDevedor(Devedores devedor) {
        this.devedor = devedor;
    }
    
    public static class Builder extends AbstractBuilder<Titulos, Builder> {

        private Builder(Titulos titulo) {
            super(titulo);
        }

        public static Builder create() {
            return new Builder(new Titulos());
        }

        public static Builder from(Titulos titulo) {
            return new Builder(titulo);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder tipoTitulo(TipoTitulo tipoTitulo) {
            entity.setTipoTitulo(tipoTitulo);
            return this;
        }
        
        public Builder numeroTitulo(String numeroTitulo) {
            entity.setNumeroTitulo(numeroTitulo);
            return this;
        }
        
        public Builder numeroParcela(int numemroParcela) {
            entity.setNumeroParcela(numemroParcela);
            return this;
        }
        
        public Builder dataVencimento(LocalDate dataVencimento) {
            entity.setDataVencimento(dataVencimento);
            return this;
        }

        public Builder valorCartorio(double valorCartorio) {
            entity.setValorCartorio(valorCartorio);
            return this;
        }
                
        public Builder valorTitulo(double valorTitulo) {
            entity.setValorTitulo(valorTitulo);
            return this;
        }
        
        public Builder devedor(Devedores devedor) {
            entity.setDevedor(devedor);
            return this;
        }
    }
}