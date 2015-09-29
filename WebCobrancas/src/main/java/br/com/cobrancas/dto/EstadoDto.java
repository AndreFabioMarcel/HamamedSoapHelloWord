package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoDto {

    @NotNull
    private Long id;

    @NotNull
    private String sigla;

    @NotNull
    private String nome;

    public EstadoDto() {
    }

    public EstadoDto(final Long id, final String sigla, final String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public static class EstadoDtoBuilder {

        private Long id;
        private String sigla;
        private String nome;

        private EstadoDtoBuilder() {
        }

        public EstadoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EstadoDtoBuilder sigla(String sigla) {
            this.sigla = sigla;
            return this;
        }

        public EstadoDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public EstadoDto Build() {
            return new EstadoDto(this.id, this.sigla, this.nome);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Estados, EstadoDto, Estados.Builder> {

        public static EstadoDtoBuilder builder() {
            return new EstadoDtoBuilder();
        }

        @Override
        public Estados fromRepresentation(EstadoDto dto, Estados.Builder builder) {
            return builder
                    .id(dto.getId())
                    .sigla(dto.getSigla())
                    .nome(dto.getNome())
                    .build();
        }

        @Override
        public EstadoDto toRepresentation(Estados t) {
            return builder()
                    .id(t.getId())
                    .sigla(t.getSigla())
                    .nome(t.getNome())
                    .Build();
        }
    }
}
