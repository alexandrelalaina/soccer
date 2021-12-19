package utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Posicao {

    DEFESA("DEFESA"),
    MEIO("MEIO"),
    ATAQUE("ATAQUE");

    private final String descricao;

}