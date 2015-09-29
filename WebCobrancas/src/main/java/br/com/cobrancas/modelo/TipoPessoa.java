package br.com.cobrancas.modelo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPessoa {

    FISICA("Pessoa Física"),
    JURIDICA("Pessoa Jurídica"),
    OUTROS("Pessoas Outros");

    private final String nome;

    private TipoPessoa(String nome) {
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
