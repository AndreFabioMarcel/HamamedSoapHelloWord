package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Enderecos;
import br.com.cobrancas.util.AbstractRepository;

public class EnderecoRepository extends AbstractRepository<Enderecos> {

    public EnderecoRepository() {
        super(Enderecos.class);
    }
}
