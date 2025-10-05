package com.soccer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AtletaStatusEnum {

    MENSALISTA("MENSALISTA"),
    AVULSO("AVULSO"),
    GOLEIRO("GOLEIRO"),
    INATIVO("INATIVO");

    private final String descricao;

}
