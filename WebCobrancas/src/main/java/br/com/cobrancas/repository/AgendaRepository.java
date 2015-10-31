package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Agendas;
import br.com.cobrancas.util.AbstractRepository;

public class AgendaRepository extends AbstractRepository<Agendas> {

    public AgendaRepository() {
        super(Agendas.class);
    }
}
