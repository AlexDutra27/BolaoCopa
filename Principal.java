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

	//	Lista com os jogos
	public static ArrayList<Grupo> grupos = new ArrayList<>();
	
	//	Executar todos os métodos do Bolão
	public static void iniciarBolao(){

		//	Instanciar times
		setarTimes();

		//	Montar grupos
		setarGruposJogos();
	}
	
	//	Iterar sobre os nomes dos times e criar os objetos correspondentes
	public static void setarTimes(){
		int i = 0;
		for (String nome : nomesTimes) {
			times.add(new Time(nome, i++));
		}
	}

	//	Instancia grupos e cria os jogos
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
}