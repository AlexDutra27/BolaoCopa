public class Jogador extends Principal {
    String nome;    //  Nome do jogador
    int numeroJog;  //  Número identificador
    int pontos;     //  Pontos realizados
    int[][] palpites = new int[48][2];  //  Palpites dos jogos
    int pontosPosicao;
    int posicao;    //  Posição no ranking final

    //  Construtor passando nome e número do jogador
    public Jogador(String nome, int numero){
        pontos = 0;
        this.nome = nome;
        this.numeroJog = numero;
    }

    //  Construtor passando nome e número do jogador
    public Jogador(String nome, int numero, int pontos){
        this.pontos = pontos;
        this.nome = nome;
        this.numeroJog = numero;
    }

    //  Incrementar pontos
    public void somaPontos(int pontos){
        this.pontos += pontos;
    }
}