package Concessionaria;

import java.util.Scanner;

public class ControleDeVendas {

	public static void main(String[] args) {
		String dadosClientes[] = {"Nome:", "CPf:", "Telefone:"};
		String dadosCarros[] = {"Marca:", "Modelo:", "Cor", "Ano:", "Valor:"};
		
		Scanner ler = new Scanner(System.in);
		
		Clientes clienteY02 = new Clientes();
		Carros carrosY02 = new Carros();
		Concessionaria Y02 = new Concessionaria();
		

		for (int a = 0; a < clienteY02.getCadastroCliente().length; a++) {
			System.out.println(" ");
			System.out.println("Gostaria de cadastrar um novo cliente? S para sim ou N para não");
			String respostaSN = ler.nextLine();
			if(respostaSN.equals("S") || respostaSN.equals("s")) {
				for(int b = 0; b < dadosClientes.length; b++){
					System.out.println(dadosClientes[b]);
					clienteY02.getCadastroCliente()[a][b] = ler.nextLine();
				}
			}
			if(respostaSN.equals("N") || respostaSN.equals("n")) {
				System.out.println("Cadastros finalizados");
				break;
			} 
			if(!respostaSN.equals("S") & !respostaSN.equals("s") & !respostaSN.equals("N") & !respostaSN.equals("n")){
				a--;
			}
		}
		
		
		for (int a = 0; a < carrosY02.getCarros().length; a++) {
			System.out.println(" ");
			System.out.println("Gostaria de cadastrar um novo carro? S para sim ou N para não");
			String respostaSN = ler.nextLine();
			if(respostaSN.equals("S") || respostaSN.equals("s")) {
				for(int b = 0; b < dadosCarros.length; b++){
					System.out.println(dadosCarros[b]);
					carrosY02.getCarros()[a][b] = ler.nextLine();
				}
			}
			if(respostaSN.equals("N") || respostaSN.equals("n")) {
				System.out.println("Cadastros finalizados");
				break;
			}
			if(!respostaSN.equals("S") & !respostaSN.equals("s") & !respostaSN.equals("N") & !respostaSN.equals("n")){
				a--;
			}
		}
		
		Y02.setRasaoSocial("Y 02");
		Y02.carros = carrosY02;
		Y02.cliente = clienteY02;
		
		
		System.out.println(" ");
		System.out.println("Lista de clientes");
		for(int x = 0; x < Y02.cliente.getCadastroCliente().length; x++) {
			for(int y = 0; y < dadosClientes.length; y++) {
				if(Y02.carros.getCarros()[x][y] != null) {
					System.out.print(Y02.cliente.getCadastroCliente()[x][y] + " | ");
				}
			}
			System.out.println(" ");
		}
		
		System.out.println("Lista de carros");
		
		for(int x = 0; x < Y02.carros.getCarros().length; x++) {
			for(int y = 0; y < dadosCarros.length; y++) {
				if(Y02.carros.getCarros()[x][y] != null) {
					System.out.print(Y02.carros.getCarros()[x][y] + " | ");	
				}
			}
			System.out.println(" ");
		}
		
		
		System.out.println("busque por um cliente pelo cpf: ");
		for(int i = 0; i < Y02.cliente.getCadastroCliente().length; i++) {
			String cpfCliente = ler.nextLine();
			if(Y02.cliente.getCadastroCliente()[i][1].equals(cpfCliente)) {
				System.out.println(" o cliente: " + Y02.cliente.getCadastroCliente()[i][0] + ", com o cpf: " + Y02.cliente.getCadastroCliente()[i][1] + " e telefone: " + Y02.cliente.getCadastroCliente()[i][2]);
			}
		}
		
	}
}
