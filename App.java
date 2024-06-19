import java.util.Scanner;
import DAO.ProdutosDAO;
import objetos.Produtos;

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
			System.out.println(" 4 -  Deletar Produto");
			System.out.println(" 5 - Sair");
				menu = sc.nextInt();
		

		switch(menu){
		
		case 1:
			
			// Variaveios para Adicionar os Atributos;
			
			long codBarra;
			String nome ;
			int quantidade;
			double valor ; 
			
			System.out.println("Digite o Codigo de Barra");
			codBarra = sc.nextLong();
			produto.setCodBarra(codBarra);
			
			/*if(codBarra == codBarraBD{
			 	* Sytem.out.Println("Produto já Cadastrador");
			 	* Sytem.out.Println("Quantos Produtos quer adicionar");
			 	* int quantidadeProduto = sc.nextInt();
			 	* int quantidade = quantidadeProduto + quantidadeBD;
			 	produtos.setquantidade(quantidade);
					
			} */
			
			// Solicitação das informaçoes dos Cliente
			
			System.out.println("Digite o nome do Produto");
			nome = sc.next();
			produto.setNome(nome);
			System.out.println("Digite a quantidade Diponivel");
			quantidade = sc.nextInt();
			produto.setQuantidade(quantidade);
			System.out.println("Digite o Valor do Produto");
			valor = sc.nextDouble();
			produto.setValor(valor);
			
			// Envia as informações coletadas para o Banco de dados;
			new ProdutosDAO().CadastrarProdutos(produto);
			
			break;
			
		case 2:
			
			//Puxa as informações do banco de Dados e lista.
			new ProdutosDAO().ListarProdutos(produto);
			
			
		break;
		
		case 3:
			 
			System.out.println(menu);
			
			break;
			
		case 4:
			
		 //variaveis locais do Codigo
		int id;
		int opcao;
		
			//laço de repetição, caso o Id digitado não esteja correto
			do {
				
				//Solicitação do ID ao usuario
				System.out.println("Digite o ID do produto que deseja excluir permanentemente");
				id = sc.nextInt();	
				
				//listando produtos por filtro, para confirmação do usuario
				new ProdutosDAO().ListarProdutos(produto, id);
				
				//solicitação de confirmação do usuario
				System.out.println("é esse produto que deseja Deletar permanentemente ? 1 - Sim 2 - Não");
				opcao = sc.nextInt();
				 
				//condicional para saber se o Id esta correto.
					if(opcao == 1) {
						
							//Deleta os dados do banco de dados 
							new ProdutosDAO().DeletarProduto(produto, id);
					}else {
						
						//Listando todos os Produtos, para o usuario descobrir qual o ID do Produto
						System.out.println("verifique o Id do produto na lista  abaixo delete novamente");
						new ProdutosDAO().ListarProdutos(produto);
		}
					
			 //condição caso não seja o Id desejado para a exclusão;	
			}while(opcao == 2);
			

		break;
		
		case 5:
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
