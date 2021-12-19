package processo;

import exception.ExceptionQtdPosicaoTime;
import model.Atleta;
import model.Selecao;
import utils.Cor;
import utils.Posicao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Convocacao {

    private final Integer qtdAtletasLinha = 6;
    private final Integer qtdAtletasDefesa = 3;
    private final Integer qtdAtletasMeio = 2;
    private final Integer qtdAtletasAtaque = 1;

    private Integer qtdTimes;
    // todos os atletas
    private List<Atleta> listaAtletas;
    // atletas selecionados
//    private List<Atleta> atletasEscalados;

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
        count = this.listaAtletas
                .stream()
                .filter(a -> a.getNivel() == 1)
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas nivel 1";

        // dividir atletas por nivel
        count = this.listaAtletas
                .stream()
                .filter(a -> a.getNivel() == 2)
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas nivel 2";

        // dividir atletas por nivel
        count = this.listaAtletas
                .stream()
                .filter(a -> a.getNivel() == 3)
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas nivel 3";

        // atletas por posicao
        count = this.listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(Posicao.DEFESA))
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas de " + Posicao.DEFESA;

        count = this.listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(Posicao.MEIO))
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas de " + Posicao.MEIO;

        count = this.listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(Posicao.ATAQUE))
                .collect(Collectors.counting());
        info = info + "\n" + count + " atletas de " + Posicao.ATAQUE;

        System.out.println("\nRelação dos Atletas\n" + info);
    }

    void validarQtdPosicaoTime(){
        if (qtdAtletasDefesa + qtdAtletasMeio + qtdAtletasAtaque != qtdAtletasLinha){
                throw new ExceptionQtdPosicaoTime(String.format("Numero de atletas(%d) por posição divergente do time(%d)!",
                        qtdAtletasDefesa + qtdAtletasMeio + qtdAtletasAtaque,
                        qtdAtletasLinha));

        }
    }

//    public List<Selecao> sortearSelecoesOld(){
//        Selecao azul = new Selecao(Cor.AZUL);
//        Selecao vermelho = new Selecao(Cor.VERMELHO);
//        Selecao amarelo = new Selecao(Cor.AMARELO);
//        Selecao branco = new Selecao(Cor.BRANCO);
//
//        List<Atleta> listaSorteio = new ArrayList<>();
//        List<Atleta> listaAtletasDefesa = ordenarAtletasPosicaoNivel(Posicao.DEFESA);
//        List<Atleta> listaAtletasMeio = ordenarAtletasPosicaoNivel(Posicao.MEIO);
//        List<Atleta> listaAtletasAtaque = ordenarAtletasPosicaoNivel(Posicao.ATAQUE);
//
//        String pickCor;
//        String pickPosicao = Posicao.DEFESA.getDescricao();
//        Boolean timesSorteados = false;
//
//        // 3 defesa // 2 meio // 1 ataque
//        while (! timesSorteados) {
//            pickCor = Cor.AZUL.getDescricao();
//
//            if (pickPosicao.equals(Posicao.DEFESA.getDescricao())){
//                listaSorteio = listaAtletasDefesa;
//                pickPosicao = Posicao.MEIO.getDescricao();
//            } else if (pickPosicao.equals(Posicao.MEIO.getDescricao())) {
//                listaSorteio = listaAtletasMeio;
//                pickPosicao = Posicao.ATAQUE.getDescricao();
//            } else if (pickPosicao.equals(Posicao.ATAQUE.getDescricao())) {
//                listaSorteio = listaAtletasAtaque;
//                timesSorteados = true;
//            }
//
//            for (Atleta listaSorteioAtletas : listaSorteio) {
//                System.out.println("Distribuindo Defesa - Atleta => " + listaSorteioAtletas.toString());
//                if (pickCor.equals(Cor.AZUL.getDescricao())) {
//                    azul.addAtleta(listaSorteioAtletas);
//                    pickCor = Cor.VERMELHO.getDescricao();
//                } else if (pickCor.equals(Cor.VERMELHO.getDescricao())) {
//                    vermelho.addAtleta(listaSorteioAtletas);
//                    if (this.qtdTimes >= 3) {
//                        pickCor = Cor.AMARELO.getDescricao();
//                    } else {
//                        pickCor = Cor.AZUL.getDescricao();
//                    }
//                } else if (pickCor.equals(Cor.AMARELO.getDescricao())) {
//                    amarelo.addAtleta(listaSorteioAtletas);
//                    if (this.qtdTimes >= 4) {
//                        pickCor = Cor.BRANCO.getDescricao();
//                    } else {
//                        pickCor = Cor.AZUL.getDescricao();
//                    }
//                }
//            }
//        }
//
//        List<Selecao> listSelecoes = new ArrayList<>();
//
//        listSelecoes.add(azul);
//        listSelecoes.add(vermelho);
//        if (this.qtdTimes >= 3) {
//            listSelecoes.add(amarelo);
//        }
//        if (this.qtdTimes >= 4) {
//            listSelecoes.add(branco);
//        }
//
//        return listSelecoes;
//    }

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

        List<Atleta> listaSorteio = new ArrayList<>();
        List<Atleta> listaAtletasDefesa = ordenarAtletasPosicaoNivel(Posicao.DEFESA);
        List<Atleta> listaAtletasMeio = ordenarAtletasPosicaoNivel(Posicao.MEIO);
        List<Atleta> listaAtletasAtaque = ordenarAtletasPosicaoNivel(Posicao.ATAQUE);

        // ATAQUE
        int i = 0;
        String selecaoParaAtleta;
        for (Atleta atleta : listaAtletasAtaque) {
            selecaoParaAtleta = recuperarSelecaoMenorNivel(listaSelecoes);
            // inserir atleta para a selecao
            // TODO refator com streams
            for (Selecao lista : listaSelecoes) {
                if (lista.getCor().getDescricao().equals(selecaoParaAtleta.toString())){
                    lista.addAtleta(atleta);
                    break;
                }
            }

            i++;
            if (i==3){
                break;
            }
        }

        return listaSelecoes;
    }

    private String recuperarSelecaoMenorNivel(List<Selecao> listaSelecoes) {
        listaSelecoes.stream()
                .sorted(Comparator.comparing(Selecao::getPontosNivel))
                .collect(Collectors.toList());
        return listaSelecoes.get(0).getCor().toString();
    }

    private List<Atleta> ordenarAtletasPosicaoNivel(Posicao posicao) {
        List<Atleta> filtro = this.listaAtletas
                .stream()
                .filter(a -> a.getPosicao().equals(posicao))
                .filter(a -> a.getEscalado()==Boolean.FALSE)
                .sorted(Comparator.comparing(Atleta::getNivel).reversed())
                .collect(Collectors.toList());

        System.out.println("Atletas de " + posicao.getDescricao());
        for (Atleta atleta : filtro) {
            System.out.println(atleta);
        }

        return filtro;
    }

    private void imprimirSelecoesEscaladas(){

    }

}
