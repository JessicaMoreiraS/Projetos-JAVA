package Sistema;

public class Vendedores {
	private String nome;
	private int id;
	private double numeroDeVendas;
	private String[][] vendasRealizadas = new String [100][3];
	
	public Vendedores(String oNome, int oId) {
		this.nome = oNome;
		this.id = oId;
		this.numeroDeVendas = 0;
	}
	
	//adiciona o valor da venda ao total vendido
	public void vendasRealizadas(double valor) {
		this.numeroDeVendas= numeroDeVendas + valor;
	}
	
	// exibe o ID e nome de cada vendedor
	public void vendedor() {
		System.out.println(" Nome do vendedor: " + nome + "\n Id do vendedor: " + id);
	}
	
	// exibe o ID, nome e total vendido de cada vendedor
	public void relatorio() {
		System.out.println(" Nome do Vendedor:" + nome +"\n ID: "+ id + "\n Numero de vendas: " + numeroDeVendas + "\n");
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String onome) {
		nome = onome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNumeroDeVendas() {
		return numeroDeVendas;
	}
	public void setNumeroDeVendas(double numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}
	public String[][] getVendasRealizadas() {
		return vendasRealizadas;
	}
	public String getVendasRealizadas(int x, int y) {
		return vendasRealizadas[x][y];
	}
	public void setVendasRealizadas(String[][] vendasRealizadas) {
		this.vendasRealizadas = vendasRealizadas;
	}
	public void setVendasRealizadas(int x, int y, String adicional) {
		this.vendasRealizadas[x][y] = adicional;
	}
	
}
