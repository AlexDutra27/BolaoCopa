public class Jogador extends Principal {
    String nome;    //  Nome do jogador
    int numeroJog;  //  Número identificador
    int pontos;     //  Pontos realizados
    int[][] palpites = new int[48][2];  //  Palpites dos jogos
    int pontosPosicao;  //  Quantidade de jogadores que este jogador está a frente
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

    //  Incrementar pontos de jogadores a frente
    public void somaPontosPosicao(int pontos){
        this.pontosPosicao += pontos;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumeroJog() {
        return this.numeroJog;
    }

    public int getPontos() {
        return this.pontos;
    }

    public int[][] getPalpites(){
        return this.palpites;
    }

    public int getPontosPosicao() {
        return this.pontosPosicao;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}