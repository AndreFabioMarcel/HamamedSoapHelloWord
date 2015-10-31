package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Credores;
import br.com.cobrancas.util.AbstractRepository;

public class CredorRepository extends AbstractRepository<Credores> {

    public CredorRepository() {
        super(Credores.class);
    }
}
