package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.PessoasJuridica;
import br.com.cobrancas.util.AbstractRepository;

public class PessoaJuridicaRepository extends AbstractRepository<PessoasJuridica> {

    public PessoaJuridicaRepository() {
        super(PessoasJuridica.class);
    }
}
