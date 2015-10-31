package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "AGENDAS_COMPROMISSOS")
public class AgendasCompromissos implements AbstractEntityId{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "TITULO")
    private String titulo;
    
    @Column(name = "COMPROMISSO")
    private String compromisso;
    
    @NotNull
    @Column(name = "DATA_COMPROMISSO")
    private LocalDate dataCompromisso;
    
    @ManyToOne
    @JoinColumn(name = "ID_AGENDA", nullable = false)
    private Agendas agenda;
    
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCompromisso() {
        return compromisso;
    }

    private void setCompromisso(String compromisso) {
        this.compromisso = compromisso;
    }

    public LocalDate getDataCompromisso() {
        return dataCompromisso;
    }

    private void setDataCompromisso(LocalDate dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public Agendas getAgenda() {
        return agenda;
    }

    private void setAgenda(Agendas agenda) {
        this.agenda = agenda;
    }
    
    public static class Builder extends AbstractBuilder<AgendasCompromissos, Builder> {

        private Builder(AgendasCompromissos agendaCompromisso) {
            super(agendaCompromisso);
        }

        public static Builder create() {
            return new Builder(new AgendasCompromissos());
        }

        public static Builder from(AgendasCompromissos agendaCompromisso) {
            return new Builder(agendaCompromisso);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder titulo(String titulo) {
            entity.setTitulo(titulo);
            return this;
        }
        
         public Builder compromisso(String compromisso) {
            entity.setCompromisso(compromisso);
            return this;
        }

        public Builder dataCompromisso(LocalDate dataCompromisso) {
            entity.setDataCompromisso(dataCompromisso);
            return this;
        }
        
        public Builder agenda(Agendas agenda) {
            entity.setAgenda(agenda);
            return this;
        }
    }
}