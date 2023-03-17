package Banco;

public class ContaCorrente extends Conta{

	public ContaCorrente(Cadastro oCliente, int aAgencia, double oSaldo) {
		super(oCliente, aAgencia, oSaldo);
	}
	
	public boolean tranferencia(double valor, Conta destinatario) {
		double imposto = 5.00;
		this.setSaldo(getSaldo()-imposto);
		tranfere(valor, destinatario);
		return true;
	}
	
	public boolean sacaCC (double valor) {
		double imposto = 5.00;
		this.setSaldo(getSaldo()-imposto);
		sacar(valor);
		return true;
	}

}
