package com.integracao.cnpj.enums;

public enum ApiEnum {
    ENDERECO("localhost"),
    PORTA("8081");

    private final String descricao;

    ApiEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
