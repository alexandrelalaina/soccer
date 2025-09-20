package com.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Soccer {

    public static void main(String[] args) {
        SpringApplication.run(Soccer.class, args);
    }

//    public static void main(String[] args) {
//        ConvocacaoService convocacao = new ConvocacaoService();
//
//        List<Selecao> listaSelecoes = convocacao.sortearSelecoes();
//
//        System.out.println("\nEscalacao");
//        for (Selecao lista : listaSelecoes) {
//            System.out.println("\nSelecao " + lista.getCor().getDescricao() + " com " + lista.getQtdAtletas() + " jogadores e nivel de " + lista.getPontosNivel() );
//
//            for (Atleta listaAtleta : lista.getListaAtletas()) {
//                System.out.println(listaAtleta.toString());
//            }
//
//        }
//
//        convocacao.imprimirSelecoesEscaladas(listaSelecoes);
//
//    }

}
