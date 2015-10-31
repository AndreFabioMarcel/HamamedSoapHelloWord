package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.enun.TipoUsuario;
import br.com.cobrancas.modelo.Usuarios;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class UsuarioDto {

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private TipoUsuario tipoUsuario;

    @NotNull
    private String usuario;

    @NotNull
    private String senha;

    @NotNull
    private LocalDate dataCadastro;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String email, TipoUsuario tipoUsuario, String usuario, String senha, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public static class UsuarioDtoBuilder {

        private Long id;
        private String nome;
        private String email;
        private TipoUsuario tipoUsuario;
        private String usuario;
        private String senha;
        private LocalDate dataCadastro;        

        private UsuarioDtoBuilder() {
        }

        public UsuarioDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioDtoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioDtoBuilder tipoUsuario(TipoUsuario tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        public UsuarioDtoBuilder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public UsuarioDtoBuilder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioDtoBuilder dataCadastro(LocalDate dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public UsuarioDto Build() {
            return new UsuarioDto(this.id, this.nome, this.email, this.tipoUsuario, this.usuario, this.senha, this.dataCadastro);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Usuarios, UsuarioDto, Usuarios.Builder> {

        public static UsuarioDtoBuilder builder() {
            return new UsuarioDtoBuilder();
        }

        @Override
        public Usuarios fromRepresentation(UsuarioDto dto, Usuarios.Builder builder) {
            return builder
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .email(dto.getEmail())
                    .tipoUsuario(dto.getTipoUsuario())
                    .usuario(dto.getUsuario())
                    .senha(dto.getSenha())
                    .dataCadast(dto.getDataCadastro())                    
                    .build();
        }

        @Override
        public UsuarioDto toRepresentation(Usuarios t) {
            return builder()
                    .id(t.getId())
                    .nome(t.getNome())
                    .email(t.getEmail())
                    .tipoUsuario(t.getTipoUsuario())
                    .usuario(t.getUsuario())
                    .senha(t.getSenha())
                    .dataCadastro(t.getDataCadastro())                    
                    .Build();
        }
    }

}
