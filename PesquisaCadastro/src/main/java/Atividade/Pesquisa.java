package Atividade;

public class Pesquisa {
	private int quantosPreferem;
	
	private int idade;
	
	private String oQuePreferem;
	
	
	
	public int getQuantosPreferem() {
		return quantosPreferem;
	}
	public void setQuantosPreferem(int quantosPreferem) {
		this.quantosPreferem = quantosPreferem;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getoQuePreferem() {
		return oQuePreferem;
	}
	public void setoQuePreferem(String oQuePreferem) {
		this.oQuePreferem = oQuePreferem;
	}

	public static void calculo(int totalEntrevistados, int preferencia, int maiores){
		int porcentagemTotal = preferencia*100/totalEntrevistados;
		int porcentagemDeMaior = maiores*100/preferencia;
		int porcentagemDeMenor = (totalEntrevistados - maiores)*100/preferencia;
		System.out.println("Há " + porcentagemTotal + " que preferem " +  ", e " + porcentagemDeMaior + " são maiores de idade.");
	}
}
