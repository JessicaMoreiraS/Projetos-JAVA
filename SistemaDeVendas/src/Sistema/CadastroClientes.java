package Sistema;

public class CadastroClientes {
	private String nome;
	private String cpf;
	private String[][] historicoDeCompras = new String [100][3];
	
	public CadastroClientes(String oNome, String oCpf) {
		this.nome = oNome;
		this.cpf = oCpf;
	}

	
	public void dadosCompra() {
		System.out.println(" Nome do CLiente: " + nome + "\n CPF do cliente: " + cpf);
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
	public String[][] getHistoricoDeCompras() {
		return historicoDeCompras;
	}
	
	public String getHistoricoDeCompras(int x, int y) {
		return historicoDeCompras[x][y];
	}
	
	public void setHistoricoDeCompras(String[][] historicoDeCompras) {
		this.historicoDeCompras = historicoDeCompras;
	}
	public void setHistoricoDeCompras(int x, int y, String adicional) {
		this.historicoDeCompras[x][y] = adicional;
	}
}
