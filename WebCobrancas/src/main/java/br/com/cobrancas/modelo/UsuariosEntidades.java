package br.com.cobrancas.modelo;

import br.com.cobrancas.enun.TipoAcessoUsuario;
import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "USUARIOS_ENTIDADES")
public class UsuariosEntidades implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_ENTIDADE", nullable = false)
    private Entidades entidade;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_ACESSO_USUARIO")
    private TipoAcessoUsuario tipoAcessoUsuario;

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

    public Usuarios getUsuario() {
        return usuario;
    }

    private void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public TipoAcessoUsuario getTipoAcessoUsuario() {
        return tipoAcessoUsuario;
    }

    private void setTipoAcessoUsuario(TipoAcessoUsuario tipoAcessoUsuario) {
        this.tipoAcessoUsuario = tipoAcessoUsuario;
    }
    
    public static class Builder extends AbstractBuilder<UsuariosEntidades, Builder> {

        private Builder(UsuariosEntidades usuarioEntidade) {
            super(usuarioEntidade);
        }

        public static Builder create() {
            return new Builder(new UsuariosEntidades());
        }

        public static Builder from(UsuariosEntidades usuarioEntidade) {
            return new Builder(usuarioEntidade);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder entidade(Entidades entidade) {
            entity.setEntidade(entidade);
            return this;
        }
        
        public Builder usuario(Usuarios usuario) {
            entity.setUsuario(usuario);
            return this;
        }
        
        public Builder tipoAcessoUsuario(TipoAcessoUsuario tipoAcessoUsuario) {
            entity.setTipoAcessoUsuario(tipoAcessoUsuario);
            return this;
        }
    }
}