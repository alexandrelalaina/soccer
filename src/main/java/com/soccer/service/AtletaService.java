package com.soccer.service;

import com.soccer.model.Atleta;
import com.soccer.model.Posicao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtletaService {

    private List<Atleta> atletaList = new ArrayList<>();

    @PostConstruct
    public void init() {
        atletaList.add(new Atleta("1", 1, Posicao.ATAQUE));
        atletaList.add(new Atleta("2", 2, Posicao.ATAQUE));
        atletaList.add(new Atleta("3", 3, Posicao.ATAQUE));
        atletaList.add(new Atleta("4", 4, Posicao.ATAQUE));
        atletaList.add(new Atleta("5", 5, Posicao.ATAQUE));

        atletaList.add(new Atleta("Abdal", 3, Posicao.ATAQUE));
        atletaList.add(new Atleta("Vinicius ", 3, Posicao.ATAQUE));
        atletaList.add(new Atleta("Régis", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Piagge", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Bruno", 3, Posicao.MEIO));
        atletaList.add(new Atleta("Luiz ( jogador novo )", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Duzão", 3, Posicao.DEFESA));
        atletaList.add(new Atleta("Cesar", 1, Posicao.MEIO));
        atletaList.add(new Atleta("Lan", 3, Posicao.MEIO));
        atletaList.add(new Atleta("Ricardo", 1, Posicao.MEIO));
        atletaList.add(new Atleta("Pipo", 1, Posicao.ATAQUE));
        atletaList.add(new Atleta("Nilo ", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Pike", 1, Posicao.DEFESA));
        atletaList.add(new Atleta("Matheus", 2, Posicao.MEIO));
        atletaList.add(new Atleta("Fabinho", 2, Posicao.MEIO));
        atletaList.add(new Atleta("Muga", 3, Posicao.MEIO));
        atletaList.add(new Atleta("Vitão", 2, Posicao.ATAQUE));
        atletaList.add(new Atleta("Gabriel", 1, Posicao.MEIO));
        atletaList.add(new Atleta("La Laina", 3, Posicao.MEIO));
        atletaList.add(new Atleta("Felipe Coêlho", 1, Posicao.MEIO));
        atletaList.add(new Atleta("Lipão ", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Caio", 2, Posicao.DEFESA));
        atletaList.add(new Atleta("Lê ", 3, Posicao.MEIO));
        atletaList.add(new Atleta("Markin", 1, Posicao.MEIO));
    }

    public List<Atleta> getAtletaList() {
        return atletaList;
    }
}
