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

                    //nivel
                    int ordenadoPorNivel1 = ordenarPorNivel(a1.getNivel());
                    int ordenadoPorNivel2 = ordenarPorNivel(a2.getNivel());

                    if (ordenadoPorNivel1 != ordenadoPorNivel2) {
                        return Integer.compare(ordenadoPorNivel1, ordenadoPorNivel2);
                    }

                    //posicao
                    int ordenacaoPorPosicao1 = ordenarPorPosicao(a1.getPosicao());
                    int ordenacaoPorPosicao2 = ordenarPorPosicao(a2.getPosicao());

                    if (ordenacaoPorPosicao1 != ordenacaoPorPosicao2) {
                        return Integer.compare(ordenacaoPorPosicao1, ordenacaoPorPosicao2);
                    }

                    //nome
                    return a1.getNome().compareTo(a2.getNome());
                })
                .collect(Collectors.toList());
    }

    private int ordenarPorPosicao(PosicaoEnum posicao) {
        if (posicao == PosicaoEnum.DEFESA) return 1;
        if (posicao == PosicaoEnum.MEIO) return 2;
        if (posicao == PosicaoEnum.ATAQUE) return 3;
        return 0;
    }

    private int ordenarPorStatus(AtletaStatusEnum status) {
        if (status == AtletaStatusEnum.ATIVO_MENSALISTA) return 0;
        if (status == AtletaStatusEnum.ATIVO_AVULSO) return 1;
        if (status == AtletaStatusEnum.INATIVO) return 2;
        return 3;
    }

    private int ordenarPorNivel(Integer nivel) {
        if (nivel == 5) return 1;
        if (nivel == 4) return 2;
        if (nivel == 3) return 3;
        if (nivel == 2) return 4;
        if (nivel == 1) return 5;
        return 6;
    }

    @PostConstruct
    private void init() {
        atletaList.add(new Atleta("La Laina", 3, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Abdal", 3, PosicaoEnum.ATAQUE, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Fabinho", 2, PosicaoEnum.MEIO));
        atletaList.add(new Atleta("Vinicius ", 3, PosicaoEnum.ATAQUE, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Régis", 2, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Piagge", 2, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Bruno", 3, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Luiz ( jogador novo )", 2, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Duzão", 3, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Cesar", 1, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Lan", 3, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Ricardo", 1, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_MENSALISTA));
        atletaList.add(new Atleta("Pipo", 1, PosicaoEnum.ATAQUE, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Nilo ", 2, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Pike", 1, PosicaoEnum.DEFESA, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Matheus", 2, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Muga", 3, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Vitão", 2, PosicaoEnum.ATAQUE, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Gabriel", 1, PosicaoEnum.MEIO, AtletaStatusEnum.ATIVO_AVULSO));
        atletaList.add(new Atleta("Felipe Coêlho", 1, PosicaoEnum.MEIO));
        atletaList.add(new Atleta("Lipão ", 2, PosicaoEnum.DEFESA));
        atletaList.add(new Atleta("Caio", 2, PosicaoEnum.DEFESA));
        atletaList.add(new Atleta("Lê ", 3, PosicaoEnum.MEIO));
        atletaList.add(new Atleta("Markin", 1, PosicaoEnum.MEIO));
    }

}
