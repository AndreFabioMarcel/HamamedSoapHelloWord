package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Negociacoes;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class NegociacaoDto {

    @NotNull
    private Long id;

    @NotNull
    private Double valorTotal;
    
    private Double desconto;

    private Double valorEntrada;

    private int numemroDeParcelas;

    private Double valorParcela;
        
    @NotNull
    private LocalDate dataVencimento;
    
    @NotNull
    private LocalDate dataNegociacao;   

    public NegociacaoDto() {
    }

    public NegociacaoDto(Long id, Double valorTotal, Double desconto, Double valorEntrada, int numemroDeParcelas, Double valorParcela, LocalDate dataVencimento, LocalDate dataNegociacao) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.valorEntrada = valorEntrada;
        this.numemroDeParcelas = numemroDeParcelas;
        this.valorParcela = valorParcela;
        this.dataVencimento = dataVencimento;
        this.dataNegociacao = dataNegociacao;
    }

    public Long getId() {
        return id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public int getNumemroDeParcelas() {
        return numemroDeParcelas;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataNegociacao() {
        return dataNegociacao;
    }

    public static class NegociacaoDtoBuilder {

        private Long id;
        private Double valorTotal;
        private Double desconto;
        private Double valorEntrada;
        private int numemroDeParcelas;
        private Double valorParcela;
        private LocalDate dataVencimento;
        private LocalDate dataNegociacao;     

        private NegociacaoDtoBuilder() {
        }

        public NegociacaoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NegociacaoDtoBuilder valorTotal(Double valorTotal) {
            this.valorTotal = valorTotal;
            return this;
        }

        public NegociacaoDtoBuilder desconto(Double desconto) {
            this.desconto = desconto;
            return this;
        }

        public NegociacaoDtoBuilder valorEntrada(Double valorEntrada) {
            this.valorEntrada = valorEntrada;
            return this;
        }

        public NegociacaoDtoBuilder numemroDeParcelas(int numemroDeParcelas) {
            this.numemroDeParcelas = numemroDeParcelas;
            return this;
        }

        public NegociacaoDtoBuilder valorParcela(Double valorParcela) {
            this.valorParcela = valorParcela;
            return this;
        }

        public NegociacaoDtoBuilder dataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
            return this;
        }

        public NegociacaoDtoBuilder dataNegociacao(LocalDate dataNegociacao) {
            this.dataNegociacao = dataNegociacao;
            return this;
        }
        
        public NegociacaoDto Build() {
            return new NegociacaoDto(this.id, this.valorTotal, this.desconto, this.valorEntrada, this.numemroDeParcelas, this.valorParcela, this.dataVencimento, this.dataNegociacao);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Negociacoes, NegociacaoDto, Negociacoes.Builder> {

        public static NegociacaoDtoBuilder builder() {
            return new NegociacaoDtoBuilder();
        }
        
        @Override
        public Negociacoes fromRepresentation(NegociacaoDto dto, Negociacoes.Builder builder) {
            return builder
                    .id(dto.getId())
                    .valorTotal(dto.getValorTotal())
                    .desconto(dto.getDesconto())
                    .valorEntrada(dto.getValorEntrada())
                    .numemroDeParcelas(dto.getNumemroDeParcelas())
                    .valorParcela(dto.getValorParcela())
                    .dataVencimento(dto.getDataVencimento())
                    .dataNegociacao(dto.getDataNegociacao())     
                    .build();
        }

        @Override
        public NegociacaoDto toRepresentation(Negociacoes t) {
            return builder()
                    .id(t.getId())
                    .valorTotal(t.getValorTotal())
                    .desconto(t.getDesconto())
                    .valorEntrada(t.getValorEntrada())
                    .numemroDeParcelas(t.getNumemroDeParcelas())
                    .valorParcela(t.getValorParcela())
                    .dataVencimento(t.getDataVencimento())
                    .dataNegociacao(t.getDataNegociacao())                   
                    .Build();
        }
    }

}
