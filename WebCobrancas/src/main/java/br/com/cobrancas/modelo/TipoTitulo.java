package br.com.cobrancas.modelo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTitulo {

    BOLETO("Boleto"),
    CHEQUE("Cheque"),
    DUPLICATA("Duplicata"),
    CONTRATO("Contrato"),
    CREDIARIO("Crediário"),
    MENSALIDADE("Mensalidade");

    private final String nome;

    private TipoTitulo(String nome) {
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
