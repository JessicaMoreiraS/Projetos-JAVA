package Sistema;

public class Gerente {
	private int senha = 123;
	
	
	// devolve verdadeiro se a senha digitada for igual a senha cadastrada.
	public boolean senhaDeAcesso(int senhaRecebida) {
		if(this.senha == senhaRecebida) {
			return true;
		}else {
			return false;
		}
	}
}
