package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.util.AbstractRepository;

public class BairroRepository extends AbstractRepository<Bairros> {

    public BairroRepository() {
        super(Bairros.class);
    }
}
