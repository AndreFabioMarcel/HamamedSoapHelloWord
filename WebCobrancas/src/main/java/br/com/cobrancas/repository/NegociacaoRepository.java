package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Negociacoes;
import br.com.cobrancas.util.AbstractRepository;

public class NegociacaoRepository extends AbstractRepository<Negociacoes> {

    public NegociacaoRepository() {
        super(Negociacoes.class);
    }
}
