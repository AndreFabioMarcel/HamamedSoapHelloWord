package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name = "NEGOCIACOES")
public class Negociacoes implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
    
    @Column(name = "DESCONTO")
    private Double desconto;

    @Column(name = "VALOR_ENTRADA")
    private Double valorEntrada;
    
    @Column(name = "NUMERO_DE_PARCELAS")
    private int numemroDeParcelas;
    
    @Column(name = "VALOR_PARCELA")
    private Double valorParcela;
        
    @NotNull
    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;
    
    @NotNull
    @Column(name = "DATA_NEGOCIACAO")
    private LocalDate dataNegociacao;   

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    private void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    private void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    private void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getNumemroDeParcelas() {
        return numemroDeParcelas;
    }

    private void setNumemroDeParcelas(int numemroDeParcelas) {
        this.numemroDeParcelas = numemroDeParcelas;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    private void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    private void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataNegociacao() {
        return dataNegociacao;
    }

    private void setDataNegociacao(LocalDate dataNegociacao) {
        this.dataNegociacao = dataNegociacao;
    }
    
    public static class Builder extends AbstractBuilder<Negociacoes, Builder> {

        private Builder(Negociacoes negociacao) {
            super(negociacao);
        }

        public static Builder create() {
            return new Builder(new Negociacoes());
        }

        public static Builder from(Negociacoes negociacao) {
            return new Builder(negociacao);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder valorTotal(double valorTotal) {
            entity.setValorTotal(valorTotal);
            return this;
        }
        
        public Builder desconto(double desconto) {
            entity.setDesconto(desconto);
            return this;
        }
        
        public Builder valorEntrada(double valorEntrada) {
            entity.setValorEntrada(valorEntrada);
            return this;
        }
        
        public Builder numemroDeParcelas(int numemroDeParcelas) {
            entity.setNumemroDeParcelas(numemroDeParcelas);
            return this;
        }
        
        public Builder valorParcela(double valorParcela) {
            entity.setValorParcela(valorParcela);
            return this;
        }
        
        public Builder dataVencimento(LocalDate dataVencimento) {
            entity.setDataVencimento(dataVencimento);
            return this;
        }

        public Builder dataNegociacao(LocalDate dataNegociacao) {
            entity.setDataNegociacao(dataNegociacao);
            return this;
        }
    }
}
