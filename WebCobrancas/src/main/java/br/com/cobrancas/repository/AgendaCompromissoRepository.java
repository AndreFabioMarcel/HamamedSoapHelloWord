package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.AgendasCompromissos;
import br.com.cobrancas.util.AbstractRepository;

public class AgendaCompromissoRepository extends AbstractRepository<AgendasCompromissos> {

    public AgendaCompromissoRepository() {
        super(AgendasCompromissos.class);
    }
}
