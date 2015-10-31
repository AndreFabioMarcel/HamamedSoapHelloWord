package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Titulos;
import br.com.cobrancas.util.AbstractRepository;

public class TituloRepository extends AbstractRepository<Titulos> {

    public TituloRepository() {
        super(Titulos.class);
    }
}
