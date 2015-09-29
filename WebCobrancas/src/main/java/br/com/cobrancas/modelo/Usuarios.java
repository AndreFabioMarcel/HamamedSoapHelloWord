package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
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

@Entity(name = "USUARIOS")
public class Usuarios implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "NOME")
    private String nome;
    
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO")
    private TipoUsuario tipoUsuario;
    
    @NotNull
    @Column(name = "USUARIO")
    private String usuario;
    
    @NotNull
    @Column(name = "SENHA")
    private String senha;
    
    @NotNull
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;
    
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

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    private void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    private void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Entidades getEntidade() {
        return entidade;
    }

    private void setEntidade(Entidades entidade) {
        this.entidade = entidade;
    }
    
    public static class Builder extends AbstractBuilder<Usuarios, Builder> {

        private Builder(Usuarios usuario) {
            super(usuario);
        }

        public static Builder create() {
            return new Builder(new Usuarios());
        }

        public static Builder from(Usuarios usuario) {
            return new Builder(usuario);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }
       
        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }
        
        public Builder email(String email) {
            entity.setEmail(email);
            return this;
        }
        
        public Builder tipoUsuario(TipoUsuario tipoUsuario) {
            entity.setTipoUsuario(tipoUsuario);
            return this;
        }

        public Builder usuario(String usuario) {
            entity.setUsuario(usuario);
            return this;
        }
                
        public Builder senha(String senha) {
            entity.setSenha(senha);
            return this;
        }

        public Builder dataCadast(LocalDate dataCadast) {
            entity.setDataCadastro(dataCadast);
            return this;
        }
        
        public Builder entidade(Entidades entidade) {
            entity.setEntidade(entidade);
            return this;
        }
    }
}