package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.modelo.Logradouros;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LogradouroDto {

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Bairros bairro;
    
    public LogradouroDto() {
    }

    public LogradouroDto(final Long id, final String nome, final Bairros bairro) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public Bairros getBairro() {
        return bairro;
    }

    public static class LogradouroDtoBuilder {

        private Long id;
        private String nome;
        private Bairros bairro;

        private LogradouroDtoBuilder() {
        }

        public LogradouroDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public LogradouroDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public LogradouroDtoBuilder bairro(Bairros bairro) {
            this.bairro = bairro;
            return this;
        }

        public LogradouroDto Build() {
            return new LogradouroDto(this.id, this.nome, this.bairro);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Logradouros, LogradouroDto, Logradouros.Builder> {

        public static LogradouroDtoBuilder builder() {
            return new LogradouroDtoBuilder();
        }

        @Override
        public Logradouros fromRepresentation(LogradouroDto dto, Logradouros.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .bairro(dto.getBairro())
                    .build();
        }

        @Override
        public LogradouroDto toRepresentation(Logradouros t) {
            return builder()
                    .id(t.getId())
                    .nome(t.getNome())
                    .bairro(t.getBairro())
                    .Build();
        }
    }
}

