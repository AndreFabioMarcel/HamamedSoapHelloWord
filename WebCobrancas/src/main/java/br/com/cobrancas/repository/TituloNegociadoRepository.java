package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.TitulosNegociados;
import br.com.cobrancas.util.AbstractRepository;

public class TituloNegociadoRepository extends AbstractRepository<TitulosNegociados> {

    public TituloNegociadoRepository() {
        super(TitulosNegociados.class);
    }
}
