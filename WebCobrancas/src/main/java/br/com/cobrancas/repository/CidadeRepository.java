package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.util.AbstractRepository;

public class CidadeRepository extends AbstractRepository<Cidades> {

    public CidadeRepository() {
        super(Cidades.class);
    }
}
