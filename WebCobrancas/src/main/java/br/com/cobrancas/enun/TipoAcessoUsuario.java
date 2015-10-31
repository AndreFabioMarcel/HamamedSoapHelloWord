package br.com.cobrancas.enun;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoAcessoUsuario {

    ADMINISTRADOR("Administrador"),
    NORMAL("Normal");

    private final String nome;

    private TipoAcessoUsuario(String nome) {
        this.nome = nome;
    }

    @JsonValue
    public String getDescription() {
        return toString();
    }

    public String getNome() {
        return this.nome;
    }
}
