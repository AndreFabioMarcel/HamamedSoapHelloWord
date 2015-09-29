package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "PESSOAS_FISICA")
public class PessoasFisica extends Pessoas {

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    private void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public static class Builder extends AbstractBuilder<PessoasFisica, Builder> {

        private Builder(PessoasFisica pessoasFisica) {
            super(pessoasFisica);
        }

        public static Builder create() {
            return new Builder(new PessoasFisica());
        }

        public static Builder from(PessoasFisica pessoasFisica) {
            return new Builder(pessoasFisica);
        }

        public Builder cpf(String cpf) {
            entity.setCpf(cpf);
            return this;
        }

        public Builder rg(String rg) {
            entity.setRg(rg);
            return this;
        }
    }
}
