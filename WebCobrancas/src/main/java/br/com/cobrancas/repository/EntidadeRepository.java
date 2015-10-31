package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.util.AbstractRepository;

public class EntidadeRepository extends AbstractRepository<Entidades> {

    public EntidadeRepository() {
        super(Entidades.class);
    }
}
