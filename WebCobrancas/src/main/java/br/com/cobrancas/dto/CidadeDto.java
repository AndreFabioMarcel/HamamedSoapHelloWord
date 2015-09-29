package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CidadeDto {

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Estados estado;

    public CidadeDto() {
    }

    public CidadeDto(final Long id, final String nome, final Estados estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Estados getEstado() {
        return estado;
    }

    public static class CidadeDtoBuilder {

        private Long id;
        private String nome;
        private Estados estado;

        private CidadeDtoBuilder() {
        }

        public CidadeDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CidadeDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public CidadeDtoBuilder estado(Estados estado) {
            this.estado = estado;
            return this;
        }

        public CidadeDto Build() {
            return new CidadeDto(this.id, this.nome, this.estado);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Cidades, CidadeDto, Cidades.Builder> {

        public static CidadeDtoBuilder builder() {
            return new CidadeDtoBuilder();
        }

        @Override
        public Cidades fromRepresentation(CidadeDto dto, Cidades.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .estado(dto.getEstado())
                    .build();
        }

        @Override
        public CidadeDto toRepresentation(Cidades t) {
            return builder()
                    .id(t.getId())
                    .nome(t.getNome())
                    .estado(t.getEstado())
                    .Build();
        }
    }

}
