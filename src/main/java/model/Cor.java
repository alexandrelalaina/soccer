package model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Cor {

    AZUL("AZUL"),
    VERMELHO("VERMELHO"),
    AMARELO("AMARELO"),
    BRANCO("BRANCO");

    private final String descricao;

}
