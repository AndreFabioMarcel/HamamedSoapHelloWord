package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "PESSOAS_JURIDICA")
public class PessoasJuridica extends Pessoas {    

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

    public static class Builder extends AbstractBuilder<PessoasJuridica, Builder> {

        private Builder(PessoasJuridica pessoasJuridicas) {
            super(pessoasJuridicas);
        }

        public static Builder create() {
            return new Builder(new PessoasJuridica());
        }

        public static Builder from(PessoasJuridica pessoasJuridicas) {
            return new Builder(pessoasJuridicas);
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
    }
}
