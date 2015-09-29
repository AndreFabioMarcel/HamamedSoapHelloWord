package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ENTIDADES")
public class Entidades implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "IE")
    private String inscricaoEstadual;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "REPRESENTANTE_LEGAL")
    private String representanteLegal;

    @Embedded
    private Contatos contato;
    
    @Column(name = "URL_LOGO")
    private String urlLogo;
    
    @Column(name = "CEP")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = true)
    private Estados estado;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE", nullable = true)
    private Cidades cidade;

    @ManyToOne
    @JoinColumn(name = "ID_BAIRRO", nullable = true)
    private Bairros bairro;

    @ManyToOne
    @JoinColumn(name = "ID_LOGRADOURO", nullable = true)
    private Logradouros logradouro;
    
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    private void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    private void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    private void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    private void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    private void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Contatos getContato() {
        return contato;
    }

    private void setContato(Contatos contato) {
        this.contato = contato;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    private void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getCep() {
        return cep;
    }

    private void setCep(String cep) {
        this.cep = cep;
    }

    public Estados getEstado() {
        return estado;
    }

    private void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Cidades getCidade() {
        return cidade;
    }

    private void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public Bairros getBairro() {
        return bairro;
    }

    private void setBairro(Bairros bairro) {
        this.bairro = bairro;
    }

    public Logradouros getLogradouro() {
        return logradouro;
    }

    private void setLogradouro(Logradouros logradouro) {
        this.logradouro = logradouro;
    }


    public static class Builder extends AbstractBuilder<Entidades, Builder> {

        private Builder(Entidades entidade) {
            super(entidade);
        }

        public static Builder create() {
            return new Builder(new Entidades());
        }

        public static Builder from(Entidades entidade) {
            return new Builder(entidade);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }
        
        public Builder cnpj(String cnpj) {
            entity.setCnpj(cnpj);
            return this;
        }

        public Builder inscricaoEstadual(String inscricaoEstadual) {
            entity.setInscricaoEstadual(inscricaoEstadual);
            return this;
        }

        public Builder razaoSocial(String razaoSocial) {
            entity.setRazaoSocial(razaoSocial);
            return this;
        }

        public Builder nomeFantasia(String nomeFantasia) {
            entity.setNomeFantasia(nomeFantasia);
            return this;
        }

        public Builder representanteLegal(String representanteLegal) {
            entity.setRepresentanteLegal(representanteLegal);
            return this;
        }
        
        public Builder contatos(Contatos contato) {
            entity.setContato(contato);
            return this;
        }
        
        public Builder urlLogo(String urlLogo) {
            entity.setUrlLogo(urlLogo);
            return this;
        }

        public Builder cep(String cep) {
            entity.setCep(cep);
            return this;
        }

        public Builder estado(Estados estado) {
            entity.setEstado(estado);
            return this;
        }

        public Builder cidade(Cidades cidade) {
            entity.setCidade(cidade);
            return this;
        }

        public Builder bairro(Bairros bairro) {
            entity.setBairro(bairro);
            return this;
        }

        public Builder logradouro(Logradouros logradouro) {
            entity.setLogradouro(logradouro);
            return this;
        }
    }
}
