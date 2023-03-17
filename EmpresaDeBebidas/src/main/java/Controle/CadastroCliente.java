package Controle;

public class CadastroCliente {
	private String nome;
	private String telefone;
	private String cpf;
	private String clientes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getClientes() {
		return clientes;
	}

	public void setClientes(String clientes) {
		this.clientes = clientes;
	}

	public double desconto (double total) {
		double desconto=0;
		if(total >= 1000 & total < 2000) {
			desconto = total*0.02;
			System.out.println("Desconto: R$" + desconto);
			System.out.println("Total pago: R$" + (total-desconto));
			return desconto;
		}
		if(total >= 2000 & total < 3000) {
			desconto = total*0.04;
			System.out.println("Desconto: R$" + desconto);
			System.out.println("Total pago: R$" + (total-desconto));
			return desconto;
		}
		if(total >= 3000) {
			desconto = total*0.06;
			System.out.println("Desconto: R$" + desconto);
			System.out.println("Total pago: R$" + (total-desconto));
			return desconto;
		}else {
			System.out.println("Desconto: R$" + desconto);
			System.out.println("Total pago: R$" + (total-desconto));
			return desconto;
		}
	}
}
