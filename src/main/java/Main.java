import model.Atleta;
import model.Selecao;
import processo.Convocacao;
import model.Posicao;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Convocacao convocacao = new Convocacao();

        List<Atleta> listaAtletas = listaAtletas();
        convocacao.relacionarAtletas(listaAtletas);

        List<Selecao> listaSelecoes = convocacao.sortearSelecoes();

        System.out.println("\nEscalacao");
        for (Selecao lista : listaSelecoes) {
            System.out.println("\nSelecao " + lista.getCor().getDescricao() + " com " + lista.getQtdAtletas() + " jogadores e nivel de " + lista.getPontosNivel() );

            for (Atleta listaAtleta : lista.getListaAtletas()) {
                System.out.println(listaAtleta.toString());
            }

        }

        convocacao.imprimirSelecoesEscaladas(listaSelecoes);

    }

    private static List<Atleta> listaAtletas() {
        List<Atleta> lisaAtletas = new ArrayList<>();

        lisaAtletas.add(new Atleta("Abdal", 3, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("Vinicius ", 3, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("Régis", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Piagge", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Bruno", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Luiz ( jogador novo )", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Duzão", 3, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Cesar", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Lan", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Ricardo", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Pipo", 1, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Nilo ", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Pike", 1, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Matheus", 2, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Fabinho", 2, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Muga", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Vitão", 2, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("Gabriel", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("La Laina", 3, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("Felipe Coêlho", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Lipão ", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Caio", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("Lê ", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Markin", 1, Posicao.MEIO));

//        lisaAtletas.add(new Atleta("La Laina", 3, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("Abdal", 3, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("xxxx", 3, Posicao.MEIO));
//
//        lisaAtletas.add(new Atleta("DEFESA-1", 1, Posicao.DEFESA));
//        lisaAtletas.add(new Atleta("DEFESA-2", 2, Posicao.DEFESA));
//        lisaAtletas.add(new Atleta("DEFESA-3", 3, Posicao.DEFESA));
//
//        lisaAtletas.add(new Atleta("MEIO-1", 1, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("MEIO-2", 2, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("MEIO-3", 3, Posicao.MEIO));
//
//        lisaAtletas.add(new Atleta("ATAQUE-1", 1, Posicao.ATAQUE));
//        lisaAtletas.add(new Atleta("ATAQUE-2", 2, Posicao.ATAQUE));
//        lisaAtletas.add(new Atleta("ATAQUE-3", 3, Posicao.ATAQUE));
//
//        lisaAtletas.add(new Atleta("DEFESA-1", 1, Posicao.DEFESA));
//        lisaAtletas.add(new Atleta("DEFESA-2", 2, Posicao.DEFESA));
//        lisaAtletas.add(new Atleta("DEFESA-3", 3, Posicao.DEFESA));
//
//        lisaAtletas.add(new Atleta("MEIO-1", 1, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("MEIO-2", 2, Posicao.MEIO));
//        lisaAtletas.add(new Atleta("MEIO-3", 3, Posicao.MEIO));
//
//        lisaAtletas.add(new Atleta("ATAQUE-1", 1, Posicao.ATAQUE));
//        lisaAtletas.add(new Atleta("ATAQUE-2", 2, Posicao.ATAQUE));
//        lisaAtletas.add(new Atleta("ATAQUE-3", 3, Posicao.ATAQUE));

        return lisaAtletas;
    }
}
