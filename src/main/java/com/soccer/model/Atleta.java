package com.soccer.model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Atleta {

    private String nome;
    private Integer nivel;  // 1 baixo // 2 medio // 3 bom
    private Posicao posicao;
    private Boolean escalado = false;
//    private AtletaStatus atletaStatus;

    public Atleta(String nome, Integer nivel, Posicao posicao) {
        this.nome = nome;
        this.nivel = nivel;
        this.posicao = posicao;
//        this.atletaStatus = AtletaStatus.INATIVO;
    }

    public static long countAtletasPorNivel(List<Atleta> listaAtletas, Integer nivel) {
        return listaAtletas
                .stream()
                .filter(a -> Objects.equals(a.getNivel(), nivel)).count();
    }

    public static long countAtletasPorPosicao(List<Atleta> listaAtletas, Posicao posicao) {
        return listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(posicao))
                .count();
    }
}
