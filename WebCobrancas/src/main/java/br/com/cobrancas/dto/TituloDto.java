package br.com.cobrancas.dto;

import br.com.cobrancas.enun.TipoTitulo;
import br.com.cobrancas.modelo.Devedores;
import br.com.cobrancas.modelo.Titulos;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class TituloDto {

    @NotNull
    private Long id;

    @NotNull
    private TipoTitulo tipoTitulo;
    
    private String numeroTitulo;
    
    private int numeroParcela;
    
    @NotNull
    private LocalDate dataVencimento;
    
    private Double valorCartorio;
    
    @NotNull
    private Double valorTitulo;
    
    @NotNull
    private Devedores devedor;

    public TituloDto() {
    }

    public TituloDto(final Long id, final TipoTitulo tipoTitulo, final String numeroTitulo, final int numeroParcela, final LocalDate dataVencimento, final Double valorCartorio, final Double valorTitulo, final Devedores devedor) {
        this.id = id;
        this.tipoTitulo = tipoTitulo;
        this.numeroTitulo = numeroTitulo;
        this.numeroParcela = numeroParcela;
        this.dataVencimento = dataVencimento;
        this.valorCartorio = valorCartorio;
        this.valorTitulo = valorTitulo;
        this.devedor = devedor;
    }

    public Long getId() {
        return id;
    }

    public TipoTitulo getTipoTitulo() {
        return tipoTitulo;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public Double getValorCartorio() {
        return valorCartorio;
    }

    public Double getValorTitulo() {
        return valorTitulo;
    }

    public Devedores getDevedor() {
        return devedor;
    }
    
    public static class TituloDtoBuilder {

        private Long id;
        private TipoTitulo tipoTitulo;
        private String numeroTitulo;
        private int numeroParcela;
        private LocalDate dataVencimento;
        private Double valorCartorio;
        private Double valorTitulo;
        private Devedores devedor;  

        private TituloDtoBuilder() {
        }

        public TituloDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TituloDtoBuilder tipoTitulo(TipoTitulo tipoTitulo) {
            this.tipoTitulo = tipoTitulo;
            return this;
        }

        public TituloDtoBuilder numeroTitulo(String numeroTitulo) {
            this.numeroTitulo = numeroTitulo;
            return this;
        }

        public TituloDtoBuilder numeroParcela(int numeroParcela) {
            this.numeroParcela = numeroParcela;
            return this;
        }

        public TituloDtoBuilder dataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
            return this;
        }

        public TituloDtoBuilder valorCartorio(Double valorCartorio) {
            this.valorCartorio = valorCartorio;
            return this;
        }

        public TituloDtoBuilder valorTitulo(Double valorTitulo) {
            this.valorTitulo = valorTitulo;
            return this;
        }

        public TituloDtoBuilder devedor(Devedores devedor) {
            this.devedor = devedor;
            return this;
        }
        
        public TituloDto Build() {
            return new TituloDto(this.id, this.tipoTitulo, this.numeroTitulo, this.numeroParcela, this.dataVencimento, this.valorCartorio, this.valorTitulo, this.devedor);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Titulos, TituloDto, Titulos.Builder> {

        public static TituloDtoBuilder builder() {
            return new TituloDtoBuilder();
        }
        
        @Override
        public Titulos fromRepresentation(TituloDto dto, Titulos.Builder builder) {
            return builder
                    .id(dto.getId())
                    .tipoTitulo(dto.getTipoTitulo())
                    .numeroTitulo(dto.getNumeroTitulo())
                    .numeroParcela(dto.getNumeroParcela())
                    .dataVencimento(dto.getDataVencimento())
                    .valorCartorio(dto.getValorCartorio())
                    .valorTitulo(dto.getValorTitulo())
                    .devedor(dto.getDevedor())     
                    .build();
        }

        @Override
        public TituloDto toRepresentation(Titulos t) {
            return builder()
                    .id(t.getId())
                    .tipoTitulo(t.getTipoTitulo())
                    .numeroTitulo(t.getNumeroTitulo())
                    .numeroParcela(t.getNumeroParcela())
                    .dataVencimento(t.getDataVencimento())
                    .valorCartorio(t.getValorCartorio())
                    .valorTitulo(t.getValorTitulo())
                    .devedor(t.getDevedor())                   
                    .Build();
        }
    }
}
