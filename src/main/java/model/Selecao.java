package model;

import lombok.Data;
import utils.Cor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Selecao {

    private Cor cor;
    private List<Atleta> listaAtletas;
    private Integer pontosNivel = 0;
    private Integer qtdAtletas = 0;

    public Selecao(Cor cor){
        this.cor = cor;
        this.listaAtletas = new ArrayList<>();
        System.out.println(cor);
    }

    public void addAtleta(Atleta atleta){
        this.listaAtletas.add(atleta);
        this.qtdAtletas++;
        this.pontosNivel+= atleta.getNivel();
        atleta.setEscalado(true);
        System.out.println("adionado ao time " + this.toString());
    }

}
