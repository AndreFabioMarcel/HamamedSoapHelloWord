package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BairroDto {

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Cidades cidade;
    
    public BairroDto() {
    }

    public BairroDto(final Long id, final String nome, final Cidades cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public static class BairroDtoBuilder {

        private Long id;
        private String nome;
        private Cidades cidade;

        private BairroDtoBuilder() {
        }

        public BairroDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BairroDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public BairroDtoBuilder cidade(Cidades cidade) {
            this.cidade = cidade;
            return this;
        }

        public BairroDto Build() {
            return new BairroDto(this.id, this.nome, this.cidade);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Bairros, BairroDto, Bairros.Builder> {

        public static BairroDtoBuilder builder() {
            return new BairroDtoBuilder();
        }

        @Override
        public Bairros fromRepresentation(BairroDto dto, Bairros.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .cidade(dto.getCidade())
                    .build();
        }

        @Override
        public BairroDto toRepresentation(Bairros t) {
            return builder()
                    .id(t.getId())
                    .nome(t.getNome())
                    .cidade(t.getCidade())
                    .Build();
        }
    }
}

