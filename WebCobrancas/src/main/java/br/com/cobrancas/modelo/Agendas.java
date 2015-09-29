package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "AGENDAS")
public class Agendas implements AbstractEntityId{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_ENTIDADE", nullable = false)
    private Entidades entidade;
    
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Entidades getEntidade() {
        return entidade;
    }

    private void setEntidade(Entidades entidade) {
        this.entidade = entidade;
    }
    
    public static class Builder extends AbstractBuilder<Agendas, Builder> {

        private Builder(Agendas agenda) {
            super(agenda);
        }

        public static Builder create() {
            return new Builder(new Agendas());
        }

        public static Builder from(Agendas agenda) {
            return new Builder(agenda);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder entidade(Entidades entidade) {
            entity.setEntidade(entidade);
            return this;
        }
    }
}