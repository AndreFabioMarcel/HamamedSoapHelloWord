package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.UsuariosEntidades;
import br.com.cobrancas.util.AbstractRepository;

public class UsuarioEntidadeRepository extends AbstractRepository<UsuariosEntidades>{
    
    public UsuarioEntidadeRepository() {
        super(UsuariosEntidades.class);
    } 
}
