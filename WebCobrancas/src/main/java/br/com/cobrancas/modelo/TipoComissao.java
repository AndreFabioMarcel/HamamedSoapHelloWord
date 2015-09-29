package br.com.cobrancas.modelo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoComissao {

    PRINCIPAL_MULTAS_JUROS("Principal + multas + juros"),
    PRINCIPAL_MULTAS_JUROS_CUSTOS("Principal + multas + juros + custos"),
    PRINCIPAL("Somente sobre o principal"),
    SOBRE_TOTAL_RECEBIDO("Sobre o total do recebimento");

    private final String nome;

    private TipoComissao(String nome) {
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
