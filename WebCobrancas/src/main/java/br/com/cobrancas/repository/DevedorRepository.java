package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Devedores;
import br.com.cobrancas.util.AbstractRepository;

public class DevedorRepository extends AbstractRepository<Devedores> {

    public DevedorRepository() {
        super(Devedores.class);
    }
}
