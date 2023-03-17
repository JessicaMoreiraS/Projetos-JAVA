package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaPrincipal {
	
	/*IMPORTANTE
	 DEIXEI OS FUNCIONARIOS JÁ CADASTRADOS, NA HORA DA VENDA DIGITE UM DOS IDS: 741, 852 OU 963;
	 
	 DEIXEI 1 CLIENTE PRÉ CADASTRADO, NA HORA DA COMPRA DIGITE O CPF: 789, *OU* FACA UMA VENDA PARA UM CLIENTE QUE NAO QUER SER CADASTRADO;
	 (E POSSIVEL CADASTRAR NOVOS CLIENTE NO SISTEMA, NO ITEM 3 DO MENU INICIAL);
	 
	 OS PRODUTOS ESTAO PRE CADASTRADOS, DEVEM SER VENDIDOS PELO ID: 951-MESA | 159-CADEIRA | 753-TOALHA DE MESA
	 
	 O(S) VENDEDOR(ES) DO ANO É(SAO) ESCOLHIDO(S) PELO MAIOR valor DE VENDAS;
	 E POSSIVEL VER O TOTAL DE VENDA DE TODOS OS VENDEDORES PELA CONTA DO GERENTE.
	 */

	public static void main(String[] args) {
		
		//cadastro de funcionarios e clientes
		Scanner in = new Scanner(System.in);
		Gerente gerente = new Gerente();
		
		Vendedores v1 = new Vendedores ("Manoel", 741);
		Vendedores v2 = new Vendedores ("Carla", 852);
		Vendedores v3 = new Vendedores ("Lucas", 963);
		
		Vendedores[] todosVendedores = {v1, v2, v3};
		
		ArrayList <CadastroClientes> listaClientes = new ArrayList<>();
		CadastroClientes c1 = new CadastroClientes("Vitor", "789");
		listaClientes.add(c1);
		
		//sequencia array= {ID PRODUTO, NOME PRODUTO, PRECO)
		String[][] litaDeProdutos = {{"951", "Mesa", "599"}, 
									{"159", "Cadeira", "200"}, 
									{"753","Toalha de mesa", "40"}};
		
		
		
		for(;;) {
			System.out.println("O que gostaria de fazer? \n1-Realizar venda  \n2-Acessar a conta do Gerente \n3-Cadastrar novo cliente \n4-Sair");
			int respostaMenu = in.nextInt();
			
			//Sistema de venda
			if(respostaMenu == 1) {
				
				//Receber informacoes para a venda
				System.out.println("Digite seu ID de vendedor:");
				int identificacaoVendedor = in.nextInt();
				
				System.out.println("Digite o id do produto vendido:");
				in.nextLine();
				String idDoProduto = in.nextLine();
				System.out.println("Quantas unidades?");
				int quantidadeComprada = in.nextInt();
				String aQuantidadeComprada = Integer.toString(quantidadeComprada);
				
				//encontrar o produto
				for(int a = 0; a<litaDeProdutos.length; a++) {
					if(litaDeProdutos[a][0].equals(idDoProduto)) {
						double precoDoProduto = Double.parseDouble(litaDeProdutos[a][2]);
						
						System.out.println("O cliente tem cadastro na loja? \n1-Sim \n2-Não");
						int respostaClienteCadastrado = in.nextInt();
						
						double totalAPagar = quantidadeComprada*precoDoProduto;
						String oValorTotalAPagar = Double.toString(totalAPagar);
						
						//Se o cliente esta cadastrado
						if(respostaClienteCadastrado == 1) {
							System.out.println("Difite o cpf do cliente:");
							in.nextLine();
							String cpfCliente = in.nextLine();
							
							//for para buscar cliente no sistema
							for(int b=0; b<listaClientes.size(); b++) {
								if(listaClientes.get(b).getCpf().equals(cpfCliente)) {
									
									//adicionar compra no historico do cliente
									for(int c = 0; c<listaClientes.get(b).getHistoricoDeCompras().length; c++) {
										if(listaClientes.get(b).getHistoricoDeCompras(c, 0) == null) {
											listaClientes.get(b).setHistoricoDeCompras(c, 0, litaDeProdutos[a][1]);
											listaClientes.get(b).setHistoricoDeCompras(c, 1, litaDeProdutos[a][2]);
											listaClientes.get(b).setHistoricoDeCompras(c, 0, aQuantidadeComprada);
										}
									}
									
									
									
									//Encontrar o vendedor e adicionar uma venda para ele
									for(int d=0; d<todosVendedores.length; d++) {
										if(todosVendedores[d].getId() == identificacaoVendedor) {
											todosVendedores[d].vendasRealizadas(totalAPagar);
											//adicionar a venda no historico do vendedor
											for(int i=0; i<todosVendedores[d].getVendasRealizadas().length; i++) {
												if(todosVendedores[d].getVendasRealizadas(i, 0) == null) {
													todosVendedores[d].setVendasRealizadas(i, 0, litaDeProdutos[a][1]); //nome do produto
													todosVendedores[d].setVendasRealizadas(i, 1, litaDeProdutos[a][2]); //preco por unidade
													todosVendedores[d].setVendasRealizadas(i, 2, oValorTotalAPagar); //total da venda
												}
											}
											
											//imprimir nota fiscal
											System.out.println("-------NOTA FISCAL---------");
											listaClientes.get(b).dadosCompra();
											todosVendedores[d].vendedor();
											System.out.println(" Produto Vendido: "+ litaDeProdutos[a][1] );
											System.out.println(" Preco por unidade: R$" + litaDeProdutos[a][2]);
											System.out.println(" Quantidade vendida: " + aQuantidadeComprada);
											System.out.println(" Total a pagar: R$" + oValorTotalAPagar );
											System.out.println("---------------------------");
											System.out.println("");
											
										}
									}
								}
							}
						}
						//Se o cliente nao esta cadastrado
						if(respostaClienteCadastrado == 2) {
							System.out.println("Digite o nome do cliente: ");
							in.nextLine();
							String nomeClienteNaoCadastrado = in.nextLine();
							System.out.println("Digite o CPF do cliente: ");
							String cpfClienteNaoCadastrado = in.nextLine();
							
							for(int d=0; d<todosVendedores.length; d++) {
								if(todosVendedores[d].getId() == identificacaoVendedor) {
									todosVendedores[d].vendasRealizadas(totalAPagar);
									//adicionar a venda no historico do vendedor
									for(int i=0; i<todosVendedores[d].getVendasRealizadas().length; i++) {
										if(todosVendedores[d].getVendasRealizadas(i, 0) == null) {
											todosVendedores[d].setVendasRealizadas(i, 0, litaDeProdutos[a][1]); //nome do produto
											todosVendedores[d].setVendasRealizadas(i, 1, litaDeProdutos[a][2]); //preco por unidade
											todosVendedores[d].setVendasRealizadas(i, 2, oValorTotalAPagar); //total da venda
										}
									}
									
									//imprimir nota fiscal
									System.out.println("-------NOTA FISCAL---------");
									System.out.println(" Nome do cliente: " + nomeClienteNaoCadastrado);
									System.out.println(" CPF do cliente: " + cpfClienteNaoCadastrado);
									todosVendedores[d].vendedor();
									System.out.println(" Produto Vendido: "+ litaDeProdutos[a][1] );
									System.out.println(" Precp por unidade: R$" + litaDeProdutos[a][2]);
									System.out.println(" Quantidade vendida: " + aQuantidadeComprada);
									System.out.println(" Total a pagar: R$" + quantidadeComprada*precoDoProduto );
									System.out.println("---------------------------");
									System.out.println("");
									
								}
							}
						}
						
					}
				}
			}
			
			//sistema do Gerente
			if(respostaMenu == 2) {
				System.out.println("Digite a sua senha de Gerente:");
				int respostaSenha = in.nextInt();
				if(gerente.senhaDeAcesso(respostaSenha)){
					for(;;) {
						System.out.println("O que gostaria de fazer? \n1-Ver venda de todos os funcionarios \n2-Ver Nome do funcionario do ano \n3-Voltar ao Menu Incial");
						int respostaMenuGerente = in.nextInt();
						if(respostaMenuGerente == 1) {
							//for para percorrer o metodo que exibe as vendas dos funcionarios
							for(int e=0; e<todosVendedores.length; e++) {
								todosVendedores[e].relatorio();
							}
						}
						if(respostaMenuGerente == 2) {
							VendedorDoAno vendedorPremiado = new VendedorDoAno();
							System.out.println(" ");
							vendedorPremiado.relatorioDeVendas(todosVendedores);
						}
						if(respostaMenuGerente == 3) {
							break;
						}
					}
				}else{
					System.out.println("Senha incorreta");
				}
			}
			
			
			//Cadastrar novo Cliente
			if(respostaMenu == 3) {
				System.out.println("Digite o nome do cliente para cadastra-lo:");
				in.nextLine();
				String nomeClienteParaCadastramento = in.nextLine();
				System.out.println("Digite o CPF do cliente: ");
				String cpfClienteParaCadastramento = in.nextLine();
				CadastroClientes cliente = new CadastroClientes(nomeClienteParaCadastramento, cpfClienteParaCadastramento);
				listaClientes.add(cliente);
				System.out.println("Cliente Cadastrado com sucesso");
				System.out.println(" ");
			}
			
			//Finalizar sistema
			if(respostaMenu == 4) {
				System.out.println("Sistema finalizado");
				break;
			}
			
		}

	}

}
