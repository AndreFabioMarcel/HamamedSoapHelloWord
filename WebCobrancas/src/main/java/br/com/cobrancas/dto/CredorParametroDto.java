package br.com.cobrancas.dto;

import br.com.cobrancas.enun.TipoComissao;
import br.com.cobrancas.modelo.Credores;
import br.com.cobrancas.modelo.CredoresParametros;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CredorParametroDto {

    @NotNull
    private Long id;
    
    @NotNull
    private Double despesasHonorarios;

    @NotNull
    private Double multaAtraso;
    
    @NotNull
    private Double taxaJuros;
       
    @NotNull
    private TipoComissao tipoComissao;

    @NotNull
    private Credores credor;

    public CredorParametroDto() {
    }
    
    public CredorParametroDto(final Long id, final Double despesasHonorarios, final Double multaAtraso, final Double taxaJuros, final TipoComissao tipoComissao, final Credores credor) {
        this.id = id;
        this.despesasHonorarios = despesasHonorarios;
        this.multaAtraso = multaAtraso;
        this.taxaJuros = taxaJuros;
        this.tipoComissao = tipoComissao;
        this.credor = credor;
    }

    public Long getId() {
        return id;
    }

    public Double getDespesasHonorarios() {
        return despesasHonorarios;
    }

    public Double getMultaAtraso() {
        return multaAtraso;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public TipoComissao getTipoComissao() {
        return tipoComissao;
    }

    public Credores getCredor() {
        return credor;
    }

    public static class CredorParametroDtoBuilder {

        private Long id;
        private Double despesasHonorarios;
        private Double multaAtraso;
        private Double taxaJuros;
        private TipoComissao tipoComissao;
        private Credores credor;

        private CredorParametroDtoBuilder() {
        }

        public CredorParametroDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CredorParametroDtoBuilder despesasHonorarios(Double despesasHonorarios) {
            this.despesasHonorarios = despesasHonorarios;
            return this;
        }

        public CredorParametroDtoBuilder multaAtraso(Double multaAtraso) {
            this.multaAtraso = multaAtraso;
            return this;
        }

        public CredorParametroDtoBuilder taxaJuros(Double taxaJuros) {
            this.taxaJuros = taxaJuros;
            return this;
        }

        public CredorParametroDtoBuilder tipoComissao(TipoComissao tipoComissao) {
            this.tipoComissao = tipoComissao;
            return this;
        }
        
        public CredorParametroDtoBuilder credor(Credores credor) {
            this.credor = credor;
            return this;
        }
        
        public CredorParametroDto Build() {
            return new CredorParametroDto(this.id, this.despesasHonorarios, this.multaAtraso, this.taxaJuros, this.tipoComissao, this.credor);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<CredoresParametros, CredorParametroDto, CredoresParametros.Builder> {

        public static CredorParametroDtoBuilder builder() {
            return new CredorParametroDtoBuilder();
        }
        
        @Override
        public CredoresParametros fromRepresentation(CredorParametroDto dto, CredoresParametros.Builder builder) {
            return builder
                    .id(dto.getId())
                    .despesasHonorarios(dto.getDespesasHonorarios())
                    .multaAtraso(dto.getMultaAtraso())
                    .taxaJuros(dto.getTaxaJuros())
                    .tipoComissao(dto.getTipoComissao())
                    .credor(dto.getCredor())
                    .build();
        }
                   
        @Override
        public CredorParametroDto toRepresentation(CredoresParametros t) {
            return builder()
                    .id(t.getId())
                    .despesasHonorarios(t.getDespesasHonorarios())
                    .multaAtraso(t.getMultaAtraso())
                    .taxaJuros(t.getTaxaJuros())
                    .tipoComissao(t.getTipoComissao())
                    .credor(t.getCredor())
                    .Build();
        }
    }
}