package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Pessoas;
import br.com.cobrancas.util.AbstractRepository;

public class PessoaRepository extends AbstractRepository<Pessoas> {

    public PessoaRepository() {
        super(Pessoas.class);
    }
}
