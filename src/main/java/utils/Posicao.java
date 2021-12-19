package utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Posicao {

    DEFESA("DEFESA"),
    MEIO("MEIO"),
    ATAQUE("ATAQUE"),
    TODAS("TODAS");

    private final String descricao;

}