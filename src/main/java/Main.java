import model.Atleta;
import model.Selecao;
import processo.Convocacao;
import utils.Posicao;

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

    }

    private static List<Atleta> listaAtletas() {
        List<Atleta> lisaAtletas = new ArrayList<>();
        
        lisaAtletas.add(new Atleta("La Laina", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("Abdal", 3, Posicao.MEIO));
        lisaAtletas.add(new Atleta("xxxx", 3, Posicao.MEIO));

        lisaAtletas.add(new Atleta("DEFESA-1", 1, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("DEFESA-2", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("DEFESA-3", 3, Posicao.DEFESA));

        lisaAtletas.add(new Atleta("MEIO-1", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("MEIO-2", 2, Posicao.MEIO));
        lisaAtletas.add(new Atleta("MEIO-3", 3, Posicao.MEIO));

        lisaAtletas.add(new Atleta("ATAQUE-1", 1, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("ATAQUE-2", 2, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("ATAQUE-3", 3, Posicao.ATAQUE));

        lisaAtletas.add(new Atleta("DEFESA-1", 1, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("DEFESA-2", 2, Posicao.DEFESA));
        lisaAtletas.add(new Atleta("DEFESA-3", 3, Posicao.DEFESA));

        lisaAtletas.add(new Atleta("MEIO-1", 1, Posicao.MEIO));
        lisaAtletas.add(new Atleta("MEIO-2", 2, Posicao.MEIO));
        lisaAtletas.add(new Atleta("MEIO-3", 3, Posicao.MEIO));

        lisaAtletas.add(new Atleta("ATAQUE-1", 1, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("ATAQUE-2", 2, Posicao.ATAQUE));
        lisaAtletas.add(new Atleta("ATAQUE-3", 3, Posicao.ATAQUE));

        return lisaAtletas;
    }
}
