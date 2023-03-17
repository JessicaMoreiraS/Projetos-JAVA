package Atividade;

public class Cadastro {
	
	private String nome;
	private int idade;
	private double peso;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean selecao(int idade){
		if(idade > 17) {
			System.out.println(" e é maior de idade.");
			return true;
		}else {
			System.out.println(" e não é maior de idade.");
			return false;
		}
	}
}
