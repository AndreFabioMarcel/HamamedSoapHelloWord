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
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;
    
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Usuarios getEntidade() {
        return usuario;
    }

    private void setEntidade(Usuarios usuario) {
        this.usuario = usuario;
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

        public Builder usuario(Usuarios usuario) {
            entity.setEntidade(usuario);
            return this;
        }
    }
}