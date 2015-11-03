package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.TitulosNegociados;
import br.com.cobrancas.modelo.Negociacoes;
import br.com.cobrancas.modelo.Titulos;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TituloNegociadoDto {

    @NotNull
    private Long id;
    
    @NotNull
    private Titulos titulo;
    
    @NotNull
    private Negociacoes negociacao;

    public TituloNegociadoDto() {
    }

    public TituloNegociadoDto(final Long id, final Titulos titulo, final Negociacoes negociacao) {
        this.id = id;
        this.titulo = titulo;
        this.negociacao = negociacao;
    }

    public Long getId() {
        return id;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    public Negociacoes getNegociacao() {
        return negociacao;
    }

    public static class TituloNegociadoDtoBuilder {

        private Long id;
        private Titulos titulo;
        private Negociacoes negociacao;

        private TituloNegociadoDtoBuilder() {
        }

        public TituloNegociadoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TituloNegociadoDtoBuilder titulo(Titulos titulo) {
            this.titulo = titulo;
            return this;
        }

        public TituloNegociadoDtoBuilder negociacao(Negociacoes negociacao) {
            this.negociacao = negociacao;
            return this;
        }

        public TituloNegociadoDto Build() {
            return new TituloNegociadoDto(this.id, this.titulo, this.negociacao);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<TitulosNegociados, TituloNegociadoDto, TitulosNegociados.Builder> {

        public static TituloNegociadoDtoBuilder builder() {
            return new TituloNegociadoDtoBuilder();
        }

        @Override
        public TitulosNegociados fromRepresentation(TituloNegociadoDto dto, TitulosNegociados.Builder builder) {
            return builder
                    .id(dto.getId())
                    .titulo(dto.getTitulo())
                    .negociacao(dto.getNegociacao())
                    .build();
        }

        @Override
        public TituloNegociadoDto toRepresentation(TitulosNegociados t) {
            return builder()
                    .id(t.getId())
                    .titulo(t.getTitulo())
                    .negociacao(t.getNegociacao())
                    .Build();
        }
    }

}
