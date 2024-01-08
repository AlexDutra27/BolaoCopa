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

    //  Retorna o time no índice passado por parâmetro na lista
    public Time getTime(int i){
        return this.times.get(i);
    }

    //  Imprimir dados do grupo
    public void infoGrupo(){
        System.out.printf("Jogos do Grupo %s (", letra);
        String timesString = "";
        for(Time time : times){
            timesString += time.nome + " | ";
        }
        timesString = timesString.substring(0, timesString.length() - 3);
        timesString += ")";
        System.out.println(timesString);
    }
}