import java.util.Scanner;

public class App {
		// Interface Principal
	public static void main(String[] args) {

		Produtos produto = new Produtos();
		int menu;
		
		int opca;
		do {
			
		Scanner sc = new Scanner (System.in);
			// Menu de Escolha do Usuário
			System.out.println("MENU");
			
			System.out.println(" 1 - Cadastrar Produtos");
			System.out.println(" 2 - Listar Produto");
			System.out.println(" 3 - Modificar Produto");
			System.out.println(" 4 - Sair");
				menu = sc.nextInt();
		
		
		switch(menu){
		
		case 1:
			//
			long codBarra;
			String nome ;
			int quantidade;
			double valor ; 
			
			System.out.println("Digite o Codigo de Barra");
			codBarra = sc.nextLong();
			
			/*if(codBarra == codBarraBD{
			 	* Sytem.out.Println("Produto já Cadastrador");
			 	* Sytem.out.Println("Quantos Produtos quer adicionar");
			 	* int quantidadeProduto = sc.nextInt();
			 	* int quantidade = quantidadeProduto + quantidadeBD;
			 	produtos.setquantidade(quantidade);
					
			} */
			
			System.out.println("Digite o nome do Produto");
			nome = sc.next();
			
			System.out.println("Digite a quantidade Diponivel");
			quantidade = sc.nextInt();
			
			System.out.println("Digite o Valor do Produto");
			valor = sc.nextDouble();
			
			produto.cadastrarProduto(codBarra, nome, quantidade, valor);
				
			break;
			
		case 2:
			
			produto.ListarProdutos();
			
		break;
		
		case 3:
			
			System.out.println(menu);
			
			break;
		case 4:
			System.exit(0);
			break;
			
		default:
			System.out.println ("Digite uma opção Valida");
				
		}
		
		System.out.println(" Deseja voltar para o menu ? SIM = 1  NAO = 2");
		opca = sc.nextInt();
		
		}while (opca == 1);
	}

}
