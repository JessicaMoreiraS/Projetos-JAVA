package Atividade;

import java.util.Scanner;

public class TestePesquisa {
	public static void main (String[]args) {
		Scanner in = new Scanner(System.in);
		
		int entrevistados =20;

		Pesquisa pesquisa[] = new Pesquisa[entrevistados];
	 
		int carro = 0;
		int casa = 0;
		int viajar = 0;
		
		for(int x = 0; x < entrevistados; x++) {
			System.out.println("Qual a idade? ");
			int idade= in.nextInt();
			pesquisa[x].setIdade(idade);
			
			System.out.println("Qual o que prefere? ");
			System.out.println("1- Casa");
			System.out.println("2- Carro");
			System.out.println("3- Viajar");
			int preferencia= in.nextInt();
			pesquisa[x].setoQuePreferem(preferencia);;
		}
		
	}
}
