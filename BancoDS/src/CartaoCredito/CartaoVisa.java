package CartaoCredito;

import Banco.Cadastro;

public class CartaoVisa {
	private double totalFatura;
	private double limite;
	private int numCartao;
	Cadastro titular;

	public CartaoVisa(Cadastro oTitular, int oNumCartao) {
		this.titular = oTitular;
		this.limite = oTitular.getSalario() * 0.6;
		this.numCartao = oNumCartao;
	}

	public boolean usarCartao(double valorGasto) {
		if (limite >= totalFatura + valorGasto) {
			this.totalFatura += valorGasto;
			return true;
		} else {
			return false;
		}
	}

	public void pagarFatura(double valor) {
		this.totalFatura -= valor; 
	}

	public double getTotalFatura() {
		return totalFatura;
	}

	public void setTotalFatura(double totalFatura) {
		this.totalFatura = totalFatura;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public int getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(int numCartao) {
		this.numCartao = numCartao;
	}
}
