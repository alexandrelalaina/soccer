package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import utils.Posicao;

@Data
public class Atleta {

    private String nome;
    private Integer nivel;  // 1 baixo // 2 medio // 3 bom
    private Posicao posicao;
    private Boolean escalado = false;

    public Atleta(String nome, Integer nivel, Posicao posicao) {
        this.nome = nome;
        this.nivel = nivel;
        this.posicao = posicao;
    }
}
