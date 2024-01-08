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

	//	Resultados dos jogos
	public static int[][] resultados = new int[48][2];
	
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

		//	Recebe os palpites
		definirPalpites();

		//	Recebe os resultados
		definirResultados();

		//	Exibir todos os resultados finais
		infoResultados();
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

	//	Receber entrada dos palpites de cada jogador e armazenar na matriz correspondente
	public static void definirPalpites(){
		System.out.println("----- Defina os Palpites -----");

		for (Jogador jogador : jogadores) {
			System.out.printf("Escreva os palpites do jogador %d: %s%n", jogador.numeroJog, jogador.nome);

			int linhas = 0;
			for(Grupo grupo : grupos){
				grupo.infoGrupo();

				for (Jogo jogo : grupo.jogos) {
					jogo.infoJogo();

					System.out.printf("%nPalpite | Gols time 1: ");
					int r1 = scan.nextInt();

					System.out.printf("Palpite | Gols time 2: ");
					int r2 = scan.nextInt();

					System.out.println(); 

					jogador.palpites[linhas][0] = r1;
					jogador.palpites[linhas][1] = r2;
					linhas++;
				}
			}
		}
		System.out.println("----- Palpites Definidos -----");
	}

	//	Receber entrada dos resultados finais de cada jogo e armazenar na matriz correspondente
	public static void definirResultados(){
		System.out.println("----- Defina os Resultados -----");

		int linhas = 0;
		for(Grupo grupo : grupos){
			grupo.infoGrupo();

			for (Jogo jogo : grupo.jogos) {
				jogo.infoJogo();

				System.out.printf("%nResultado | Gols time 1: ");
				int r1 = scan.nextInt();

				System.out.printf("Resultado | Gols time 2: ");
				int r2 = scan.nextInt();

				System.out.println();

				resultados[linhas][0] = r1;
				resultados[linhas][1] = r2;
				linhas++;
			}
		}
	}

	//	Exibe todos os resultados inputados
	public static void infoResultados(){
		for(int linha = 0; linha < 48; linha++){
			System.out.println();
			jogos.get(linha).infoJogo();
			System.out.printf("%d x %d", resultados[linha][0], resultados[linha][1]);
		}
	}
}