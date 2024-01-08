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
	
	//	Executar todos os métodos do Bolão
	public static void iniciarBolao(){

		//	Instanciar times
		setarTimes();
	}
	
	//	Iterar sobre os nomes dos times e criar os objetos correspondentes
	public static void setarTimes(){
		int i = 0;
		for (String nome : nomesTimes) {
			times.add(new Time(nome, i++));
		}
	}
}