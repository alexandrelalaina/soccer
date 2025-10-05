package com.soccer.service;

import com.soccer.model.Atleta;
import com.soccer.model.AtletaStatusEnum;
import com.soccer.model.PosicaoEnum;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class AtletaService {

    private final List<Atleta> atletaList = new ArrayList<>();

    public List<Atleta> getOrdenarPadraoList() {
        return atletaList.stream()
                .sorted((a1, a2) -> {
                    //status
                    int ordenadoPorStatus1 = ordenarPorStatus(a1.getAtletaStatus());
                    int ordenadoPorStatus2 = ordenarPorStatus(a2.getAtletaStatus());

                    if (ordenadoPorStatus1 != ordenadoPorStatus2) {
                        return Integer.compare(ordenadoPorStatus1, ordenadoPorStatus2);
                    }

                    //posicao
                    int ordenacaoPorPosicao1 = ordenarPorPosicao(a1.getPosicao());
                    int ordenacaoPorPosicao2 = ordenarPorPosicao(a2.getPosicao());

                    if (ordenacaoPorPosicao1 != ordenacaoPorPosicao2) {
                        return Integer.compare(ordenacaoPorPosicao1, ordenacaoPorPosicao2);
                    }

                    //nivel
                    int ordenadoPorNivel1 = ordenarPorNivel(a1.getNivel());
                    int ordenadoPorNivel2 = ordenarPorNivel(a2.getNivel());

                    if (ordenadoPorNivel1 != ordenadoPorNivel2) {
                        return Integer.compare(ordenadoPorNivel1, ordenadoPorNivel2);
                    }

                    //nome
                    return a1.getNome().compareTo(a2.getNome());
                })
                .collect(Collectors.toList());
    }

    private int ordenarPorPosicao(PosicaoEnum posicao) {
        if (posicao == PosicaoEnum.GOLEIRO) return 1;
        if (posicao == PosicaoEnum.DEFESA) return 2;
        if (posicao == PosicaoEnum.MEIO) return 3;
        if (posicao == PosicaoEnum.ATAQUE) return 4;
        return 10;
    }

    private int ordenarPorStatus(AtletaStatusEnum status) {
        if (status == AtletaStatusEnum.GOLEIRO) return 1;
        if (status == AtletaStatusEnum.MENSALISTA) return 2;
        if (status == AtletaStatusEnum.AVULSO) return 3;
        if (status == AtletaStatusEnum.INATIVO) return 4;
        return 10;
    }

    private int ordenarPorNivel(Integer nivel) {
        if (nivel == 5) return 1;
        if (nivel == 4) return 2;
        if (nivel == 3) return 3;
        if (nivel == 2) return 4;
        if (nivel == 1) return 5;
        return 10;
    }

    @PostConstruct
    private void init() {
        atletaList.add(new Atleta("Custela", 3, PosicaoEnum.GOLEIRO, AtletaStatusEnum.GOLEIRO));
        atletaList.add(new Atleta("Loredo", 3, PosicaoEnum.GOLEIRO, AtletaStatusEnum.GOLEIRO));

        atletaList.add(new Atleta("Lipão ", 3, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Andre", 1, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Juan", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Matheus", 3, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Valdir", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Luquinha", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Lee", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Luiz", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Rigola", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Augusto", 4, PosicaoEnum.DEFESA, AtletaStatusEnum.AVULSO));

        atletaList.add(new Atleta("La Laina", 5, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Muga", 4, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Gustavo Careca", 5, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Lan", 5, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Thiago Bispo", 4, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Robson", 4, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Luan", 4, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Rene", 4, PosicaoEnum.MEIO, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Stiven", 4, PosicaoEnum.MEIO, AtletaStatusEnum.AVULSO));
        atletaList.add(new Atleta("Fercho", 4, PosicaoEnum.MEIO, AtletaStatusEnum.AVULSO));
        atletaList.add(new Atleta("Celinho", 2, PosicaoEnum.MEIO, AtletaStatusEnum.AVULSO));

        atletaList.add(new Atleta("Abdal", 5, PosicaoEnum.ATAQUE, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Pipo", 5, PosicaoEnum.ATAQUE, AtletaStatusEnum.MENSALISTA));
        atletaList.add(new Atleta("Renan", 5, PosicaoEnum.ATAQUE, AtletaStatusEnum.AVULSO));
    }

}
