package com.soccer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PosicaoEnum {

    GOLEIRO("Goleiro"),
    DEFESA("Defesa"),
    MEIO("Meio"),
    ATAQUE("Ataque"),
    TODAS("TODAS");

    private final String descricao;

}