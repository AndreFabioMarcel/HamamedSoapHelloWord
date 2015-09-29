package br.com.cobrancas.repository;

import br.com.cobrancas.modelo.Usuarios;
import br.com.cobrancas.util.AbstractRepository;

public class UsuarioRepository extends AbstractRepository<Usuarios>{
    
    public UsuarioRepository() {
        super(Usuarios.class);
    } 
}
