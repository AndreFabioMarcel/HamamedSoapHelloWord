package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Agendas;
import br.com.cobrancas.modelo.AgendasCompromissos;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
    public class AgendaCompromissoDto {

    @NotNull
    private Long id;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String compromisso;
    
    @NotNull
    private LocalDate dataCompromisso;
    
    @NotNull
    private Agendas agenda;

    public AgendaCompromissoDto() {
    }

    public AgendaCompromissoDto(final Long id, final String titulo, final String compromisso, final LocalDate dataCompromisso, final Agendas agenda) {
        this.id = id;
        this.titulo = titulo;
        this.compromisso = compromisso;
        this.dataCompromisso = dataCompromisso;
        this.agenda = agenda;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCompromisso() {
        return compromisso;
    }

    public LocalDate getDataCompromisso() {
        return dataCompromisso;
    }

    public Agendas getAgenda() {
        return agenda;
    }

    public static class AgendaCompromissoDtoBuilder {

        private Long id;
        private String titulo;
        private String compromisso;
        private LocalDate dataCompromisso;
        private Agendas agenda;

        private AgendaCompromissoDtoBuilder() {
        }

        public AgendaCompromissoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AgendaCompromissoDtoBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public AgendaCompromissoDtoBuilder compromisso(String compromisso) {
            this.compromisso = compromisso;
            return this;
        }

        public AgendaCompromissoDtoBuilder dataCompromisso(LocalDate dataCompromisso) {
            this.dataCompromisso = dataCompromisso;
            return this;
        }

        public AgendaCompromissoDtoBuilder agenda(Agendas agenda) {
            this.agenda = agenda;
            return this;
        }

        public AgendaCompromissoDto Build() {
            return new AgendaCompromissoDto(this.id, this.titulo, this.compromisso, this.dataCompromisso, this.agenda);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<AgendasCompromissos, AgendaCompromissoDto, AgendasCompromissos.Builder> {

        public static AgendaCompromissoDtoBuilder builder() {
            return new AgendaCompromissoDtoBuilder();
        }

        @Override
        public AgendasCompromissos fromRepresentation(AgendaCompromissoDto dto, AgendasCompromissos.Builder builder) {
            return builder
                    .id(dto.getId())
                    .titulo(dto.getTitulo())
                    .compromisso(dto.getCompromisso())
                    .dataCompromisso(dto.getDataCompromisso())
                    .agenda(dto.getAgenda())
                    .build();
        }

        @Override
        public AgendaCompromissoDto toRepresentation(AgendasCompromissos t) {
            return builder()
                    .id(t.getId())
                    .titulo(t.getTitulo())
                    .compromisso(t.getCompromisso())
                    .dataCompromisso(t.getDataCompromisso())
                    .agenda(t.getAgenda())
                    .Build();
        }
    }
}