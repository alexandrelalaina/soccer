package com.soccer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AtletaStatusEnum {

    INATIVO("INATIVO"),
    ATIVO_MENSALISTA("ATIVO_MENSALISTA"),
    ATIVO_AVULSO("ATIVO_AVULSO");

    private final String descricao;

}
