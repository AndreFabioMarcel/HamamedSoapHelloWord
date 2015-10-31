package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Agendas;
import br.com.cobrancas.modelo.Usuarios;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AgendaDto {

    @NotNull
    private Long id;

    @NotNull
    private Usuarios usuario;
    
    public AgendaDto() {
    }

    public AgendaDto(final Long id, final Usuarios usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
    
    public Usuarios getEntidade() {
        return usuario;
    }

    public static class AgendaDtoBuilder {

        private Long id;
        private Usuarios usuario;

        private AgendaDtoBuilder() {
        }

        public AgendaDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AgendaDtoBuilder usuario(Usuarios usuario) {
            this.usuario = usuario;
            return this;
        }

        public AgendaDto Build() {
            return new AgendaDto(this.id, this.usuario);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Agendas, AgendaDto, Agendas.Builder> {

        public static AgendaDtoBuilder builder() {
            return new AgendaDtoBuilder();
        }

        @Override
        public Agendas fromRepresentation(AgendaDto dto, Agendas.Builder builder) {
            return builder
                    .id(dto.getId())
                    .usuario(dto.getEntidade())
                    .build();
        }

        @Override
        public AgendaDto toRepresentation(Agendas t) {
            return builder()
                    .id(t.getId())
                    .usuario(t.getEntidade())
                    .Build();
        }
    }
}