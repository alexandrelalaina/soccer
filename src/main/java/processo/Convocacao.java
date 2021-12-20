package processo;

import exception.ExceptionQtdPosicaoTime;
import model.Atleta;
import model.Selecao;
import model.Cor;
import model.Posicao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Convocacao {

    private final Integer qtdAtletasDefesa = 3;
    private final Integer qtdAtletasMeio = 2;
    private final Integer qtdAtletasAtaque = 1;
    private final Integer qtdAtletasLinha = qtdAtletasDefesa + qtdAtletasMeio + qtdAtletasAtaque;

    private Integer qtdTimes;
    private List<Atleta> listaAtletas;

    public Convocacao() {
        validarQtdPosicaoTime();
    }

    public void relacionarAtletas(List<Atleta> listaAtletas){
        this.listaAtletas = listaAtletas;

        this.listaAtletas
                .stream()
                .forEach(atleta -> System.out.println(atleta.toString()));

        infoRelacaoAtletas();
    }

    private void infoRelacaoAtletas() {
        String info;
        long count;

        //total atletas
        info = this.listaAtletas.size() + " atletas a serem relacionados";

        // qtos times??
        this.qtdTimes = this.listaAtletas.size() / this.qtdAtletasLinha;
        info = info + "\n" + this.qtdTimes + " times";

        // suplentes
        count = this.listaAtletas.size() % qtdAtletasLinha;
        if (count!=0){
            info = info + String.format(" + %d atletas suplentes", count) ;
        }

        // dividir atletas por nivel
        count = Atleta.countAtletasPorNivel(this.listaAtletas, 1);

        info = info + "\n" + count + " atletas nivel 1";

        count = Atleta.countAtletasPorNivel(this.listaAtletas, 2);

        info = info + "\n" + count + " atletas nivel 2";

        count = Atleta.countAtletasPorNivel(this.listaAtletas, 3);

        info = info + "\n" + count + " atletas nivel 3";

        // atletas por posicao

        count = Atleta.countAtletasPorPosicao(this.listaAtletas, Posicao.DEFESA);

        info = info + "\n" + count + " atletas de " + Posicao.DEFESA.getDescricao();

        count = Atleta.countAtletasPorPosicao(this.listaAtletas, Posicao.MEIO);

        info = info + "\n" + count + " atletas de " + Posicao.MEIO.getDescricao();

        count = Atleta.countAtletasPorPosicao(this.listaAtletas, Posicao.ATAQUE);

        info = info + "\n" + count + " atletas de " + Posicao.ATAQUE.getDescricao();

        System.out.println("\nRelação dos Atletas\n" + info);
    }

    void validarQtdPosicaoTime(){
        if (qtdAtletasDefesa + qtdAtletasMeio + qtdAtletasAtaque != qtdAtletasLinha){
                throw new ExceptionQtdPosicaoTime(String.format("Numero de atletas(%d) por posição divergente do time(%d)!",
                        qtdAtletasDefesa + qtdAtletasMeio + qtdAtletasAtaque,
                        qtdAtletasLinha));

        }
    }

    public List<Selecao> sortearSelecoes(){
        List<Selecao> listaSelecoes = new ArrayList<>();

        Selecao azul = new Selecao(Cor.AZUL);
        listaSelecoes.add(azul);

        Selecao vermelho = new Selecao(Cor.VERMELHO);
        listaSelecoes.add(vermelho);

        if (this.qtdTimes >= 3) {
            Selecao amarelo = new Selecao(Cor.AMARELO);
            listaSelecoes.add(amarelo);
        }
        if (this.qtdTimes >= 4) {
            Selecao branco = new Selecao(Cor.BRANCO);
            listaSelecoes.add(branco);
        }

        int iPosicao = 1;
        int qtdAtletasNaPosicao = 0;
        int qtdAtletasNaPosicaoEscalados = 0;
        String selecaoParaAtleta;
        boolean sorteioFinalizado = false;
        List<Atleta> listaSorteio = new ArrayList<>();

        // TODO pensar em criar classe Posicao
        while (! sorteioFinalizado) {
            qtdAtletasNaPosicaoEscalados = 0;
            if (iPosicao==1){
                listaSorteio = ordenarAtletasPosicaoNivel(Posicao.ATAQUE);
                qtdAtletasNaPosicao = this.qtdAtletasAtaque;
                System.out.println(String.format("\nSortear %d Atletas da posição de Ataque!", listaSorteio.size()) );
            } else if (iPosicao==2){
                listaSorteio = ordenarAtletasPosicaoNivel(Posicao.MEIO);
                qtdAtletasNaPosicao = this.qtdAtletasMeio;
                System.out.println(String.format("\nSortear %d Atletas da posição de Meio!", listaSorteio.size()) );
            } else if (iPosicao==3){
                listaSorteio = ordenarAtletasPosicaoNivel(Posicao.DEFESA);
                qtdAtletasNaPosicao = this.qtdAtletasDefesa;
                System.out.println(String.format("\nSortear %d Atletas da posição de Defesa!", listaSorteio.size()) );
            } else if (iPosicao==4){
                listaSorteio = ordenarAtletasPosicaoNivel(Posicao.TODAS);
                qtdAtletasNaPosicao = this.qtdAtletasDefesa + this.qtdAtletasMeio + this.qtdAtletasAtaque;
                qtdAtletasNaPosicaoEscalados = qtdAtletasJaEscalados(listaSelecoes);
                System.out.println(String.format("\nSortear %d Atletas em qualquer posição...", listaSorteio.size()) );
            }

            for (Atleta atleta : listaSorteio) {
                // inserir atleta para a selecao
                // TODO refator com streams
                for (Selecao lista : listaSelecoes) {
                    selecaoParaAtleta = recuperarSelecaoMenorNivel(listaSelecoes);
                    if (lista.getCor().toString().equals(selecaoParaAtleta)) {
                        lista.addAtleta(atleta);
                        break;
                    }
                }

                qtdAtletasNaPosicaoEscalados++;
                if (qtdAtletasNaPosicaoEscalados == this.qtdTimes * qtdAtletasNaPosicao) {
                    break;
                }
            }
            iPosicao++;
            if (iPosicao==5){
                sorteioFinalizado = true;
                break;
            }
        }

        listaSelecoes = ordenarListaSelecaoFinal(listaSelecoes);

        return listaSelecoes;
    }

    private List<Selecao> ordenarListaSelecaoFinal(List<Selecao> listaSelecoes) {
        var listaSelecoesAtualizada = listaSelecoes;
        // atualizar lista de jogadores
        // TODO refatorar ordenacao
        int i = 0;
        for (Selecao lista : listaSelecoes) {
            List<Atleta> listaAtletasOrdenada = lista.getListaAtletas()
                    .stream()
                    .sorted(Comparator.comparing(Atleta::getNivel))
                    .sorted(Comparator.comparing(Atleta::getPosicao))
                    .collect(Collectors.toList());
            listaSelecoesAtualizada.get(i).setListaAtletas(listaAtletasOrdenada);
            i++;
        }
        return listaSelecoesAtualizada;
    }

    private int qtdAtletasJaEscalados(List<Selecao> listaSelecoes) {
        return listaSelecoes.stream()
                .collect(Collectors.summingInt(value -> value.getQtdAtletas()));
    }

    private String recuperarSelecaoMenorNivel(List<Selecao> listaSelecoes) {
        List<Selecao> aux = listaSelecoes.stream()
//                .sorted(Comparator.comparing(Selecao::getQtdAtletas))
                .filter(selecao -> selecao.getQtdAtletas() < this.qtdAtletasLinha)
                .sorted(Comparator.comparingInt(Selecao::getPontosNivel))
                .collect(Collectors.toList());
//        // como nao posso
//        for (Selecao selecao : aux) {
//            if (aux.get(0).getQtdAtletas() != this.qtdAtletasLinha){
//                break;
//            }
//        }
        return aux.get(0).getCor().toString();
    }

    private List<Atleta> ordenarAtletasPosicaoNivel(Posicao posicao) {
        List<Atleta> filtro;

        if (posicao.equals(Posicao.TODAS)) {
            filtro = this.listaAtletas
                    .stream()
                    .filter(a -> a.getEscalado() == Boolean.FALSE)
                    .sorted(Comparator.comparing(Atleta::getNivel).reversed())
                    .collect(Collectors.toList());
            System.out.println("Atletas de TODAS as posições que faltam ser escalados");
        } else {
            filtro = this.listaAtletas
                    .stream()
                    .filter(a -> a.getPosicao().equals(posicao))
                    .filter(a -> a.getEscalado()==Boolean.FALSE)
                    .sorted(Comparator.comparing(Atleta::getNivel).reversed())
                    .collect(Collectors.toList());
            System.out.println("Atletas de " + posicao.getDescricao());
        }

        for (Atleta atleta : filtro) {
            System.out.println(atleta);
        }

        return filtro;
    }

    public void imprimirSelecoesEscaladas(List<Selecao> listaSelecoes){
        System.out.println(" ");
        System.out.println("================================================================");
        System.out.println(" ");
        for (Selecao listaSelecoe : listaSelecoes) {
            System.out.println("Seleção " + listaSelecoe.getCor() + " nivel " + listaSelecoe.getPontosNivel());
            for (Atleta listaAtleta : listaSelecoe.getListaAtletas()) {
                System.out.println(String.format(" (%s)%s (%s)",
                        listaAtleta.getPosicao().getDescricao().substring(0,1),
                        listaAtleta.getNome(),
                        listaAtleta.getNivel())
                );
            }
        }
    }

}
