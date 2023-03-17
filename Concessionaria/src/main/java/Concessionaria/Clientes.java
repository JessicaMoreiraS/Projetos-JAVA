package Concessionaria;

public class Clientes {
	
	String cadastroCliente[][] = new String [10][3]; /*o primeiro [] é o numero de linhas e o segundo [] é o número de colunas*/
	

	public String[][] getCadastroCliente() {
		return cadastroCliente;
	}

	public void setCadastroCliente(String[][] cadastroCliente) {
		this.cadastroCliente = cadastroCliente;
	}
	

}
