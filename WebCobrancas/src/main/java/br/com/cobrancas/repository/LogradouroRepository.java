package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Logradouros;
import br.com.cobrancas.util.AbstractRepository;

public class LogradouroRepository extends AbstractRepository<Logradouros> {

    public LogradouroRepository() {
        super(Logradouros.class);
    }
}
