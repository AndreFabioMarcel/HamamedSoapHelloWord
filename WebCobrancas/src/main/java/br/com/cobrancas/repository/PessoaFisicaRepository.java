package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.PessoasFisica;
import br.com.cobrancas.util.AbstractRepository;

public class PessoaFisicaRepository extends AbstractRepository<PessoasFisica> {

    public PessoaFisicaRepository() {
        super(PessoasFisica.class);
    }
}
