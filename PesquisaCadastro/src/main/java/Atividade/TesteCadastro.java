package Atividade;

import java.util.Scanner;

public class TesteCadastro {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		
		int tamanho;
		String nome;
		int idade;
		double peso;
		
		System.out.println("total de cadastros");
		tamanho = in.nextInt();
		Cadastro cadastro[] = new Cadastro[tamanho];
		
		for(int i = 0; i < tamanho ; i++) {
			System.out.println("Novo cadastro");
			cadastro[i] = new Cadastro();
			
			System.out.println("Nome : ");
			in.nextLine();
			nome = in.nextLine();
			cadastro[i].setNome(nome);
			
			System.out.println("Idade : ");
			idade = in.nextInt();
			cadastro[i].setIdade(idade);
			
			System.out.println("Peso : ");
			peso = in.nextDouble();
			cadastro[i].setPeso(peso);
			
			System.out.println(" ");
		}
		
		for(int i = 0; i < tamanho; i++) {
			System.out.print("• " + cadastro[i].getNome() + " tem " + cadastro[i].getIdade() + " anos e " + cadastro[i].getPeso() + "Kgs");
			cadastro[i].selecao(cadastro[i].getIdade());
		}
	}
}
