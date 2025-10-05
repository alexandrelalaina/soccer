package com.soccer.model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Atleta {

    private String nome;
    private Integer nivel;  // 1 baixo // 2 medio // 3 bom
    private PosicaoEnum posicao;
    private Boolean escalado = false;
    private AtletaStatusEnum atletaStatus;

    public Atleta(String nome, Integer nivel, PosicaoEnum posicao) {
        this.nome = nome;
        this.nivel = nivel;
        this.posicao = posicao;
        this.atletaStatus = AtletaStatusEnum.INATIVO;
    }

    public Atleta(String nome, Integer nivel, PosicaoEnum posicao, AtletaStatusEnum atletaStatus) {
        this.nome = nome;
        this.nivel = nivel;
        this.posicao = posicao;
        this.atletaStatus = atletaStatus;
    }

    public static long countAtletasPorNivel(List<Atleta> listaAtletas, Integer nivel) {
        return listaAtletas
                .stream()
                .filter(a -> Objects.equals(a.getNivel(), nivel)).count();
    }

    public static long countAtletasPorPosicao(List<Atleta> listaAtletas, PosicaoEnum posicaoEnum) {
        return listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(posicaoEnum))
                .count();
    }
}
