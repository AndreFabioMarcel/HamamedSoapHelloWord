package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "PESSOAS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoas implements AbstractEntityId {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PESSOA")
    private TipoPessoa tipoPessoa;

    @NotNull
    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @Embedded
    private Contatos contato;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_ENDERECO")
    private List<Enderecos> enderecos;

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    private void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Contatos getContato() {
        return contato;
    }

    private void setContato(Contatos contato) {
        this.contato = contato;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    private void setEnderecos(List<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    private void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public static class Builder extends AbstractBuilder<Pessoas, Builder> {

        private Builder(Pessoas pessoa) {
            super(pessoa);
        }

        public static Builder create() {
            return new Builder(new Pessoas() {
            });
        }

        public static Builder from(Pessoas pessoa) {
            return new Builder(pessoa);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder tipoPessoa(TipoPessoa tipoPessoa) {
            entity.setTipoPessoa(tipoPessoa);
            return this;
        }

        public Builder dataCadastro(LocalDate dataCadastro) {
            entity.setDataCadastro(dataCadastro);
            return this;
        }

        public Builder contatos(Contatos contato) {
            entity.setContato(contato);
            return this;
        }

        public Builder enderecos(List<Enderecos> enderecos) {
            entity.setEnderecos(enderecos);
            return this;
        }
    }
}
