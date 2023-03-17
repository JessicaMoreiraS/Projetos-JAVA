package Controle;

import java.util.Scanner;

public class Execucao {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Criacao de objetos clientes
		CadastroCliente cliente1 = new CadastroCliente();
		CadastroCliente cliente2 = new CadastroCliente();
		CadastroCliente cliente3 = new CadastroCliente();
		CadastroCliente cliente4 = new CadastroCliente();
		CadastroCliente clientes[] = new CadastroCliente[4];
		clientes[0]= cliente1;
		clientes[1]= cliente2;
		clientes[2]= cliente3;
		clientes[3]= cliente4;
		
		
		//Criação de objetos e cadastro sucos
		CadastroProduto produto1 = new CadastroProduto();
		CadastroProduto produto2 = new CadastroProduto();
		CadastroProduto produto3 = new CadastroProduto();
		CadastroProduto produto4 = new CadastroProduto();
		
		produto1.setSabores("uva");
		produto1.setMls(600);
		produto1.setPrecos(5);
		produto2.setSabores("laranja");
		produto2.setMls(600);
		produto2.setPrecos(6);
		produto3.setSabores("goiaba");
		produto3.setMls(600);
		produto3.setPrecos(4);
		produto4.setSabores("limão");
		produto4.setMls(600);
		produto4.setPrecos(4);
		
		
		//Cadastro dos clientes
		for(int x = 0; x < clientes.length; x++) {
			System.out.println("Gostaria de cadastrar um novo clienete? S para sim e N para não");
			String respostaSN = in.nextLine();
			if(respostaSN.equals("S") || respostaSN.equals("s")) {
				System.out.println("Digite o nome: ");
				String nomes = in.nextLine();
				clientes[x].setNome(nomes);
				System.out.println("Digite o telefone: ");
				String telefones = in.nextLine();
				clientes[x].setTelefone(telefones);
				System.out.println("Digite o cpf: ");
				String cpfs = in.nextLine();
				clientes[x].setCpf(cpfs);
			}
			if(respostaSN.equals("N") || respostaSN.equals("n")) {
				System.out.println("Cadastro finalizado");
				break;
			}
		}
		
		
		//Cadastrando o pedido do cliente
		System.out.println("Digite o cpf do cliente referente ao pedido ");
		String cpf = in.nextLine();
		for(int x = 0; x < clientes.length; x++) {
			if(clientes[x].getCpf().equals(cpf)) { /*Verificando se o cliente existe no sistema*/
				System.out.println("Digite o pedido:");
				
				System.out.println("Unidades de " + produto1.getSabores() + " " + produto1.getMls() + "ml: ");
				int quantidade1 = in.nextInt();
				
				System.out.println("Unidades de " + produto2.getSabores() + " " + produto2.getMls() + "ml: ");
				int quantidade2 = in.nextInt();
				
				System.out.println("Unidades de " + produto3.getSabores() + " "+ produto3.getMls() + "ml: ");
				int quantidade3 = in.nextInt();
				
				System.out.println("Unidades de " + produto4.getSabores() + " " + produto4.getMls() + "ml: ");
				int quantidade4 = in.nextInt();
				
				
				//Imprimir o  pedido do cliente
				System.out.println("-------------------------------------------------");
				System.out.println("O cliente: " + clientes[x].getNome());
				System.out.println("Fez o pedido: ");
				System.out.println("• " + quantidade1 + " und. de suco de " + produto1.getSabores() + " " + produto1.getMls() + "ml - subtotal R$" + produto1.getPrecos()*quantidade1);
				System.out.println("• " + quantidade2 + " und. de suco de " + produto2.getSabores() + " " + produto2.getMls() + "ml - subtotal R$" + produto2.getPrecos()*quantidade2);
				System.out.println("• " + quantidade3 + " und. de suco de " + produto3.getSabores() + " " + produto3.getMls() + "ml - subtotal R$" + produto3.getPrecos()*quantidade3);
				System.out.println("• " + quantidade4 + " und. de suco de " + produto4.getSabores() + " " + produto4.getMls() + "ml - subtotal R$" + produto4.getPrecos()*quantidade4);
				double total = (quantidade1*produto1.getPrecos()) + (quantidade2*produto2.getPrecos()) + (quantidade3*produto3.getPrecos()) + (quantidade4*produto4.getPrecos());
				System.out.println("Total da compra - R$" + total);
				double totalDesconto = clientes[x].desconto(total);
				return;
			}
			if(!clientes[x].getCpf().equals(cpf)) { /*Caso o cliente não exista no sistema*/
				System.out.println("Cliente não encontrado");
				return;
			}
			
		}
	}

}
