package Banco;

import java.util.Scanner;

import CartaoCredito.CartaoVisa;

public class CriarConta {
	public static void main (String[]args) {
		Scanner in = new Scanner(System.in);
		
		Cadastro cadCc1 = new Cadastro ("João Silva", "111.111.111-01", "1111-1111", 2000);
		ContaCorrente cc1 = new ContaCorrente(cadCc1, 300, 100);
		CartaoVisa cartaoCc1 = new CartaoVisa(cadCc1, 222);
		Cadastro cadCc2 = new Cadastro ("Maria Dantas", "222.222.222-02", "2222-2222", 2500);
		ContaCorrente cc2 = new ContaCorrente(cadCc2, 123, 450);
		Cadastro cadCc3 = new Cadastro ("Antonio Soares", "333.333.333-03", "3333-3333", 5000);
		ContaCorrente cc3 = new ContaCorrente(cadCc3, 123, 1000);
		
		Cadastro cadCp1 = new Cadastro ("Julia Morais", "444.444.444-04", "4444-4444", 10000);
		ContaPoupanca cp1 = new ContaPoupanca(cadCp1 , 300, 120);
		Cadastro cadCp2 = new Cadastro ("Carlos Andrade", "555.555.555-05", "5555-5555", 10000);
		ContaPoupanca cp2 = new ContaPoupanca(cadCp2, 123, 2000);
		Cadastro cadCp3 = new Cadastro ("Ricardo Araujo", "666.666.666-06", "6666-6666", 1300);
		ContaPoupanca cp3 = new ContaPoupanca(cadCp3, 300, 610);
		
		
		String[] requisicoesRemetente = {"Qual a sua conta? \n 1 - Conta Corrente \n 2 - Conta Poupança", "Digite sua agencia", "Digite sua conta"};
		String[] requisicoesDestinatario = {"Qual a conta destino para essa operação? \n 1 - Conta Corrente \n 2 - Conta Poupança", "Digite a agencia do detinatário", "Digite a conta"};
		int[] respostasRemetente = new int[3];
		int[] respostasDestinatario = new int[3];
		
		ContaCorrente[] contasC = new ContaCorrente[3];
		contasC[0]= cc1;
		contasC[1]= cc2;
		contasC[2]= cc3;
		
		ContaPoupanca[] contasP = new ContaPoupanca[3];
		contasP[0]= cp1;
		contasP[1]= cp2;
		contasP[2]= cp3;
		
		CartaoVisa[] titulares = new CartaoVisa[1];
		titulares[0] = cartaoCc1;
		
		System.out.println(contasC[1].getAgencia() + " " +contasC[1].getConta());
		System.out.println(contasP[2].getAgencia() + " " +contasP[2].getConta());

	
		for(int r = 0; r < 2; r++) {
//								Coleta de informa��es para realizar operacoes
		System.out.println("Qual operação você gostaria de realizar? \n 1- Consulta \n 2- Saque \n 3- Deposito \n 4- Transferência \n 5- Usar o cartão de crédito \n 6- Pagar a fatura do cartão de crédito \n 7- Finalizar operações");
		int operacao = in.nextInt();
		

		
		switch (operacao) {
		//Para Saque
		case 1: 
			//Informacoes para identificar quem esta fazendo a operacao
			for(int a = 0; a<requisicoesRemetente.length; a++) {
				System.out.println(requisicoesRemetente[a]);
				respostasRemetente[a] = in.nextInt();
			}
			switch (respostasRemetente[0]) {
			//De Conta Corrente
			case 1:
				for(int y = 0; y < contasC.length; y++) {
					if(contasC[y].getAgencia() == respostasRemetente[1] & contasC[y].getConta() == respostasRemetente[2]){
						System.out.println("Seu saldo é de: R$" + contasC[y].getSaldo());
						return;
					}
				}
				break;
			//De Conta Poupanca
			case 2: 
				for(int y = 0; y < contasC.length; y++) {
					if(contasP[y].getAgencia() == respostasRemetente[1] & contasP[y].getConta() == respostasRemetente[2]){
						System.out.println("Seu saldo é de: R$" + contasP[y].getSaldo());
						return;
					}
				}
				break;
			}
		case 2:
			//Valor a ser transferido
			System.out.println("Qual o valor?");
			double valor = in.nextDouble();
			
			//Informa��es para identificar quem esta fazendo a operacao
			for(int a = 0; a<requisicoesRemetente.length; a++) {
				System.out.println(requisicoesRemetente[a]);
				respostasRemetente[a] = in.nextInt();
			}

			switch (respostasRemetente[0]) {
			//De Conta Corrente
			case 1:
				for(int y = 0; y < contasC.length; y++) {
					if(contasC[y].getAgencia() == respostasRemetente[1] & contasC[y].getConta() == respostasRemetente[2]){
						contasC[y].sacaCC(valor);
						System.out.println("Seu saldo é de: R$" + contasC[y].getSaldo());
					}
				}
				break;
			//De Conta Poupanca
			case 2: 
				for(int y = 0; y < contasC.length; y++) {
					if(contasP[y].getAgencia() == respostasRemetente[1] & contasP[y].getConta() == respostasRemetente[2]){
						contasP[y].sacar(valor);
						System.out.println("Seu saldo é de: R$" + contasP[y].getSaldo());
					}
				}
				break;
			}
			break;
			
		//Para Deposito
		case 3:
			//Valor a ser transferido
			System.out.println("Qual o valor?");
			valor = in.nextDouble();
			
			//Informações para buscar o destinatario
			for(int a = 0; a<requisicoesDestinatario.length; a++) {
				System.out.println(requisicoesDestinatario[a]);
				respostasDestinatario[a] = in.nextInt();
			}
			
//								Validacao das informacoes e execucao do deposito
			switch(respostasDestinatario[0]) {
			//Para Conta Corrente
			case 1:
				for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatario
					if(contasC[x].getAgencia() == respostasDestinatario[1] & contasC[x].getConta() == respostasDestinatario[2]) {
						contasC[x].deposito(valor);
					}
				}
				break;
			//Para Conta Poupan�a
			case 2:
				for(int x = 0; x < contasP.length; x++) { //Busca pelo destinatario
					if(contasP[x].getAgencia() == respostasDestinatario[1] & contasP[x].getConta() == respostasDestinatario[2]) {
						contasP[x].deposito(valor);
					}
				}
				break;
			}
			break;
			
		//Para Transferencia	
		case 4:
			//Valor a ser transferido
			System.out.println("Qual o valor?");
			valor = in.nextDouble();
			
			//Informa��es para identificar quem esta fazendo a operacao
			for(int a = 0; a<requisicoesRemetente.length; a++) {
				System.out.println(requisicoesRemetente[a]);
				respostasRemetente[a] = in.nextInt();
			}
			
			for(int a = 0; a<requisicoesDestinatario.length; a++) {
				System.out.println(requisicoesDestinatario[a]);
				respostasDestinatario[a] = in.nextInt();
			}
			
			
//										 Validacao das informacoes e execucao da transferencia
			switch(respostasRemetente[0]) {
			//Transferencia de Conta Corrente
			case 1:
				
				for(int y = 0; y < contasC.length; y++) {
					if(contasC[y].getAgencia() == respostasRemetente[1] & contasC[y].getConta() == respostasRemetente[2]) { //Identificao do Remetente
						switch(respostasDestinatario[0]) {
						//Para Conta Corrente
						case 1:
							for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatario
								if(contasC[x].getAgencia() == respostasDestinatario[1] & contasC[x].getConta() == respostasDestinatario[2]) {
									contasC[y].tranferencia(valor, contasC[x]);
									System.out.println(" ");
									System.out.println("De: " + contasC[y].cliente.getNome() + "\nPara: " + contasC[x].cliente.getNome() + "\nNo valor de: R$" + valor);
									System.out.println("Seu saldo é de: R$" + contasC[y].getSaldo());
									return;	
								}else {
									if(x == contasC.length -1) {
										System.out.println("Destinatário não encontrado");
										return;
									}
								}
							}
							break;
						//Para conta Poupanca
						case 2:
							for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatario
								if(contasP[x].getAgencia() == respostasDestinatario[1] & contasP[x].getConta() == respostasDestinatario[2]) {
									contasC[y].tranferencia(valor, contasP[x]);
									System.out.println(" ");
									System.out.println("De: " + contasC[y].cliente.getNome() + "\nPara: " + contasP[x].cliente.getNome() + "\nNo valor de: R$" + valor);
									System.out.println("Seu saldo é de: R$" + contasC[y].getSaldo());
									return;	
								}else {
									if(x == contasP.length -1) {
										System.out.println("Destinatário n�o encontrado");
										return;
									}
								}
							}
							break;
						}
					}
				}
			break;
			//De Conta Poupan�a
			case 2:
				for(int y = 0; y < contasP.length; y++) {
					if(contasP[y].getAgencia() == respostasRemetente[1] & contasP[y].getConta() == respostasRemetente[2]) { //Identificacao do Remetente
						switch(respostasDestinatario[0]) {
						//Para Conta Corrente
						case 1:
							for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatario
								if(contasC[x].getAgencia() == respostasDestinatario[1] & contasC[x].getConta() == respostasDestinatario[2]) {
									contasP[y].tranfere(valor, contasC[x]);
									System.out.println(" ");
									System.out.println("De: " + contasP[y].cliente.getNome() + "\nPara: " + contasC[x].cliente.getNome() + "\nNo valor de: R$" + valor);
									System.out.println("Seu saldo é de: R$" + contasP[y].getSaldo());
									return;	
								}else {
									if(x == contasC.length -1) {
										System.out.println("Destinatário não encontrado");
										return;
									}
								}
							}
							break;
						//Para Conta Poupanca
						case 2:
							for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatario
								if(contasP[x].getAgencia() == respostasDestinatario[1] & contasP[x].getConta() == respostasDestinatario[2]) {
									contasP[y].tranfere(valor, contasP[x]);
									System.out.println(" ");
									System.out.println("De: " + contasP[y].cliente.getNome() + "\nPara: " + contasP[x].cliente.getNome() + "\nNo valor de: R$" + valor);
									System.out.println("Seu saldo é de: R$" + contasP[y].getSaldo());
									return;	
								}else {
									if(x == contasP.length -1) {
										System.out.println("Destinatário não encontrado");
										return;
									}
								}
							}
							break;
						}
					}
				}
				break;
			}		
			break;
		case 5:
			System.out.println("Digite o numero do seu cartão:");
			int numeroDoCartao = in.nextInt();
			System.out.println("Qual o valor a ser gasto?");
			valor = in.nextDouble();
			for(int w = 0; w < titulares.length; w++) {
				if(titulares[w].getNumCartao() == numeroDoCartao) {
					if(titulares[w].usarCartao(valor)) {
						System.out.println("Compra realizada com sucesso");
						break;
					}else {
						System.out.println("O limite do cartão não é suficiente para essa compra");
						break;
					}
				}
			}
		case 6:
			System.out.println("Digite o numero do seu cartão:");
			numeroDoCartao = in.nextInt();
			System.out.println("Qual o valor a ser pago?");
			valor = in.nextDouble();
			for(int w = 0; w < titulares.length; w++) {
				if(titulares[w].getNumCartao() == numeroDoCartao) {
					titulares[w].pagarFatura(valor);
						System.out.println("Fatura paga com sucesso");
						break;
				}
			}
		case 7:
			return;
		}
		r=0;
		}

//		System.out.println("Quanto gostaria de sacar?");
//		double valor=in.nextDouble();
//		cc3.sacar(valor)
//		
//		System.out.println(" ");
//		
//		
//		System.out.println("Quanto voc� gostaria de depositar?");
//		valor = in.nextDouble();
//		if(cc3.deposito(valor)) {
//			System.out.println("Deposito realizado com sucesso \nO valor da conta �: R$" + cc3.getSaldo());
//		}
//		System.out.println(" ");
		
		
//		System.out.println("Quanto você gostaria de transferir?"); //Informações para buscar o destinatário
//		double valor = in.nextDouble();
//		System.out.println("Digite a agencia do detinatário");
//		int agencia = in.nextInt();
//		System.out.println("Digite a conta");
//		int conta = in.nextInt();
//		
//		for(int x = 0; x < contasC.length; x++) { //Busca pelo destinatário
//			if(contasC[x].getAgencia() == agencia & contasC[x].getConta() == conta) {
//				cc3.tranfere(valor, contasC[x]);
//				return;	
//			}else {
//				if(x == contasC.length -1) {
//					System.out.println("Destinatário não encontrado");
//					return;
//				}
//			}
//		}
		
		
//		if(cc3.tranfere(20, cp1)) {
//			System.out.println("transferencia realizada com sucesso");
//		}
		
	}
}

//System.out.println("Qual a sua conta? \n� 1 - Conta Corrente \n� 2 - Conta Poupança");
//int tipoContaRemetente = in.nextInt();
//System.out.println("Digite sua agencia");
//int nAgencia = in.nextInt();
//System.out.println("Digite sua conta");
//int nConta = in.nextInt();

////Informações para buscar o destinatario
//System.out.println("Para que conta gostaria de tranferir? \n� 1 - Conta Corrente \n� 2 - Conta Poupan�a");
//int tipoContaDestinatario = in.nextInt();
//System.out.println("Digite a agencia do detinat�rio");
//int agencia = in.nextInt();
//System.out.println("Digite a conta");
//int conta = in.nextInt();
