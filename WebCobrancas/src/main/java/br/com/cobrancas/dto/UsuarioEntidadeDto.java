package br.com.cobrancas.dto;

import br.com.cobrancas.enun.TipoAcessoUsuario;
import br.com.cobrancas.modelo.UsuariosEntidades;
import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.modelo.Usuarios;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioEntidadeDto {

    @NotNull
    private Long id;
    
    @NotNull
    private Entidades entidade;
    
    @NotNull
    private Usuarios usuario;
    
    @NotNull
    private TipoAcessoUsuario tipoAcessoUsuario;

    public UsuarioEntidadeDto() {
    }

    public UsuarioEntidadeDto(final Long id, final Entidades entidade, final Usuarios usuario, final TipoAcessoUsuario tipoAcessoUsuario) {
        this.id = id;
        this.entidade = entidade;
        this.usuario = usuario;
        this.tipoAcessoUsuario = tipoAcessoUsuario;
    }

    public Long getId() {
        return id;
    }

    public Entidades getEntidade() {
        return entidade;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public TipoAcessoUsuario getTipoAcessoUsuario() {
        return tipoAcessoUsuario;
    }

    public static class UsuarioEntidadeDtoBuilder {

        private Long id;
        private Entidades entidade;
        private Usuarios usuario;
        private TipoAcessoUsuario tipoAcessoUsuario;
        
        private UsuarioEntidadeDtoBuilder() {
        }

        public UsuarioEntidadeDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioEntidadeDtoBuilder entidade(Entidades entidade) {
            this.entidade = entidade;
            return this;
        }
        
        public UsuarioEntidadeDtoBuilder usuario(Usuarios usuario) {
            this.usuario = usuario;
            return this;
        }
        
        public UsuarioEntidadeDtoBuilder tipoAcessoUsuario(TipoAcessoUsuario tipoAcessoUsuario) {
            this.tipoAcessoUsuario = tipoAcessoUsuario;
            return this;
        }

        public UsuarioEntidadeDto Build() {
            return new UsuarioEntidadeDto(this.id, this.entidade, this.usuario, this.tipoAcessoUsuario);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<UsuariosEntidades, UsuarioEntidadeDto, UsuariosEntidades.Builder> {

        public static UsuarioEntidadeDtoBuilder builder() {
            return new UsuarioEntidadeDtoBuilder();
        }
        
        @Override
        public UsuariosEntidades fromRepresentation(UsuarioEntidadeDto dto, UsuariosEntidades.Builder builder) {
            return builder
                    .id(dto.getId())
                    .entidade(dto.getEntidade())
                    .usuario(dto.getUsuario())
                    .tipoAcessoUsuario(dto.getTipoAcessoUsuario())
                    .build();
        }

        @Override
        public UsuarioEntidadeDto toRepresentation(UsuariosEntidades t) {
            return builder()
                    .id(t.getId())
                    .entidade(t.getEntidade())
                    .usuario(t.getUsuario())
                    .tipoAcessoUsuario(t.getTipoAcessoUsuario())
                    .Build();
        }
    }
}