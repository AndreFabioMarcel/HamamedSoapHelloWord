package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.util.AbstractRepository;

public class EstadoRepository extends AbstractRepository<Estados> {

    public EstadoRepository() {
        super(Estados.class);
    }
}
