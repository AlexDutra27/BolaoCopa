import java.util.ArrayList;

public class Grupo {
    ArrayList<Time> times = new ArrayList<>();  //  Lista de 4 times
    ArrayList<Jogo> jogos = new ArrayList<>();  //  Lista de 6 jogos
    String letra;                               //  Letra identificadora do grupo

    //  Construtor recebendo todos os atributos
    public Grupo(ArrayList<Time> times, String letra) {
        this.times = times;
        this.letra = letra;
    }

    public void setJogos(ArrayList<Jogo> jogos){
        this.jogos = jogos;
    }
}