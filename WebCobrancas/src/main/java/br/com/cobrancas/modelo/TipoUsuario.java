package br.com.cobrancas.modelo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoUsuario {

    INTERNO("Interno"),
    EXTERNO("Externo");

    private final String nome;

    private TipoUsuario(String nome) {
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
