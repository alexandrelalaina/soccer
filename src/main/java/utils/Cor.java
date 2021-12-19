package utils;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Cor {

    AZUL("Azul"),
    VERMELHO("Vermelho"),
    AMARELO("Amarelo"),
    BRANCO("Branco");

    private final String descricao;

}
