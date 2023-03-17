package Sistema;

public class VendedorDoAno{

	//invoca o método relatório() da classe Vendedores
	public void relatorioDeVendas(Vendedores[] todosVendedores) {
		double maiorNumeroDeVendas=0;
		for(int x=0; x<todosVendedores.length; x++) {
			todosVendedores[x].getNumeroDeVendas();
			if(x==0) {
				maiorNumeroDeVendas = todosVendedores[x].getNumeroDeVendas();
			}
			//descobrindo o maior numero de vendas
			if(todosVendedores[x].getNumeroDeVendas()> maiorNumeroDeVendas) {
				maiorNumeroDeVendas = todosVendedores[x].getNumeroDeVendas();
			}
			if(x == todosVendedores.length-1) {
				System.out.println("---------------------------------------");
				System.out.println("-> O maior valor de numero de vendas foi de: " + maiorNumeroDeVendas + " <-");
				System.out.println("Do(s) vendedor(es): ");
				for(int y=0; y<todosVendedores.length; y++) {
					if(todosVendedores[y].getNumeroDeVendas() == maiorNumeroDeVendas) {
						System.out.print("- ");
						todosVendedores[y].vendedor();
						System.out.println("");
					}
				}
				System.out.println("---------------------------------------");
				System.out.println(" ");
			}
		}
	}

}
