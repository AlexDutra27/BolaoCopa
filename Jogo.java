public class Jogo {
    Time time1, time2;          //  Times
    int[] placar = new int[2];  //  Placar do jogo
    int numero;                 //  Número do jogo
    
    //  Construtor recebendo times e número do jogo
    public Jogo(Time time1, Time time2, int numero){
        this.time1 = time1;
        this.time2 = time2;  
        this.numero = numero;
    }
}