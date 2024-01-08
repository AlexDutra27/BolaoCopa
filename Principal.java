import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Principal{
	//	Variável de Scanner para captar a entrada do usuário
	public static Scanner scan = new Scanner(System.in);

	//	Lista com os nomes dos times
	public static final ArrayList<String> nomesTimes = new ArrayList<>(Arrays.asList(
		"Qatar",       "Equador", 		"Senegal", 		"Holanda",
		"Inglaterra",  "Ira", 			"EUA", 			"Gales",
		"Argentina",   "Arabia", 		"Mexico", 		"Polonia",
		"Franca",      "Australia", 	"Dinamarca", 	"Tunisia",
		"Espanha",     "Costa Rica", 	"Alemanha", 	"Japao",
		"Belgica",     "Canada", 		"Marrocos", 	"Croacia",
		"Brasil",      "Servia", 		"Suica", 		"Camaroes",
		"Portugal",    "Gana",			"Uruguai",		"Coreia"
	));
	
	//	Lista dos objetos dos times
	public static ArrayList<Time> times = new ArrayList<>();

	//	Lista com as letras identificadoras de cada grupo
	public static final ArrayList<String> letrasGrupos = new ArrayList<>(Arrays.asList(
		"A", "B", "C", "D", "E", "F", "G", "H"
	));

	//	Lista com os grupos
	public static ArrayList<Grupo> grupos = new ArrayList<>();

	//	Lista com os jogos
	public static ArrayList<Jogo> jogos = new ArrayList<>();

	//	Lista de jogadores do bolão
	public static ArrayList<Jogador> jogadores = new ArrayList<>();
	
	//	Executar todos os métodos do Bolão
	public static void iniciarBolao(){

		//	Instanciar times
		setarTimes();

		//	Montar grupos
		setarGruposJogos();

		//	Criar os jogos a partir dos grupos
		criarJogos();

		//	Recebe os jogadores por input do usuário
		definirJogadores();
	}
	
	//	Iterar sobre os nomes dos times e criar os objetos correspondentes
	public static void setarTimes(){
		int i = 0;
		for (String nome : nomesTimes) {
			times.add(new Time(nome, i++));
		}
	}

	//	Instancia os grupos
	public static void setarGruposJogos(){

		//	Monta os grupos em uma lista contendo listas de 4 times cada
		ArrayList<ArrayList<Time>> timesEmGrupos = new ArrayList<>();
		for(int i = 0; i < 32; i += 4){
			timesEmGrupos.add(new ArrayList<>(times.subList(i, i + 4)));
		}

		//	Cria os grupos e adiciona em uma lista
		int i = 0;
		for(String letra : letrasGrupos){
			grupos.add(new Grupo(timesEmGrupos.get(i++), letra));
		}
	}

	//	Popular o array de jogos usando uma lista de grupos, fazendo cada time do grupo jogar com os demais
	public static void criarJogos() {
		int numeroJogo = 1;
		for(Grupo grupo : grupos){
			ArrayList<Jogo> jogosGrupo = new ArrayList<>();
			jogosGrupo.add(new Jogo(grupo.getTime(0), grupo.getTime(1), numeroJogo++));
			jogosGrupo.add(new Jogo(grupo.getTime(0), grupo.getTime(2), numeroJogo++));
			jogosGrupo.add(new Jogo(grupo.getTime(0), grupo.getTime(3), numeroJogo++));
			jogosGrupo.add(new Jogo(grupo.getTime(1), grupo.getTime(2), numeroJogo++));
			jogosGrupo.add(new Jogo(grupo.getTime(1), grupo.getTime(3), numeroJogo++));
			jogosGrupo.add(new Jogo(grupo.getTime(2), grupo.getTime(3), numeroJogo++));

			grupo.setJogos(jogosGrupo);

			jogos.addAll(jogosGrupo);
		}
	}

	//	Captar os nomes dos jogadores e salvar na lista correspondente
	public static void definirJogadores(){
		System.out.println("----- Defina os Jogadores -----");
		
		int numeroJogador = 1;
		char res;
		do{
			System.out.printf("Jogador %d: ", numeroJogador);               
			jogadores.add(new Jogador(scan.nextLine(), numeroJogador));

			System.out.println("Para encerrar a adição, digite \"x\". Senão. digite qualquer tecla");
			res = scan.nextLine().charAt(0);

			numeroJogador++;
		}while(res != 'x');

		System.out.println("----- Jogadores Definidos -----");
	}
}