package Concessionaria;

public class Concessionaria {

	Clientes cliente; /*V�nculando uma classe na outra, agora a classe Concessionaria tem Clientes e Carros*/
	Carros carros;
	
	private String rasaoSocial;

	
	public String getRasaoSocial() {
		return rasaoSocial;
	}

	public void setRasaoSocial(String rasaoSocial) {
		this.rasaoSocial = rasaoSocial;
	}
	
}
