package Banco;

public abstract class Conta {
	private int conta;
	private int agencia;
	private double saldo;
	Cadastro cliente;
	
	static int totalContasDaAge123 = 520;
	static int totalContasDaAge300 = 340;
	
	
	public Conta(Cadastro oCliente, int aAgencia, double oSaldo) {
		this.cliente = oCliente;
		this.agencia = aAgencia;
		this.saldo = oSaldo;
		if(aAgencia == 123) {
			totalContasDaAge123++;
			this.conta = totalContasDaAge123;
		}
		if(aAgencia == 300) {
			totalContasDaAge300++;
			this.conta = totalContasDaAge300;
		}
		if(aAgencia != 123 & aAgencia != 300) {
			System.out.println("Agencia não encontrada");
		}
	}

	
	
	public boolean deposito(double valorDeposito) {
		this.saldo = saldo + valorDeposito;
		System.out.println("Operação realizada com sucesso");
		return true;
	}
	
	public boolean sacar(double valorSaque) {
		if(valorSaque > this.saldo) {
			System.out.println("Saldo insuficiente para realisar essa operação");
			return false;
		}else {
			this.saldo = this.saldo - valorSaque;
			System.out.println("Operação realizada com sucesso");
			return true;
		}
	}
	
	public boolean tranfere(double valor, Conta destinatario) {
		if(sacar(valor)) {
			destinatario.deposito(valor);
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
