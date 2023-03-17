package Banco;

public class Cadastro {
	private String nome;
	private String cpf;
	private String telefone;
	private double salario;
	
	public Cadastro(String oNome, String oCpf, String oTelefone, double oSalario) {
		this.nome=oNome;
		this.cpf=oCpf;
		this.telefone=oTelefone;
		this.salario=oSalario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
