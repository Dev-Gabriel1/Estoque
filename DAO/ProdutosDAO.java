package DAO;
import Conexao.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import objetos.Produtos;

public class ProdutosDAO {
	
	// Metodo Cadastrar Produtos
	public void CadastrarProdutos(Produtos produto){
		
		//Linha de Comando SQL que insere Dados na tabela
		String sql = "INSERT INTO PRODUTOS (NOME , CODIGODEBARRA , QUANTIDADE, VALOR )  VALUE ( ? , ? , ? , ? )";
		
		//Codigo para Preparar o Codigo SQL
		PreparedStatement ps = null;
		
		
		try {
			
			//Abrindo conexão e preparando o codigo SQL
			ps = conexao.getConexao().prepareStatement(sql);
			
			// Setando por SQL, os Atributos do objeto Produto, para enviar para o banco de dados.
			ps.setString(1 , produto.getNome());
			ps.setLong(2, produto.getCodBarra());
			ps.setInt(3, produto.getQuantidade());
			ps.setDouble(4, produto.getValor());
			
			//Codigo que executa o comando SQL
			ps.execute();
			
			// COdigo que fecha a Conexao com o banco de dados;
			ps.close();
			
		} catch (SQLException e) {
			
			// mensagem de erro caso não consiga realizar o cadastro
			System.out.println("Erro ao cadastar Produto" + e.getMessage());

		}
		
	}
	
	//Metodo Listar Produto
	public void ListarProdutos(Produtos produto){
		
		//Linha de Codigo SQL
		String sql =" SELECT * FROM produtos";
		
		//Metodo que prepara o comando SQL
		PreparedStatement ps = null;
		
		try {
			
			//Abrindo conexão e preparando o codigo SQL
			ps = conexao.getConexao().prepareStatement(sql);
			
			//Metodo que mostra os resultados em um array;
			ResultSet resultSet = ps.executeQuery();	
		
			// COdigo para listagem de uma array
			while(resultSet.next()){
				
				//codigo para pegar as informações do banco de dados e jogar nas variaveis para fazer o listamento
				int colunaid = resultSet.getInt("idProdutos");
				String colunaNome = resultSet.getString("Nome");
				Long colunaCodBarra = resultSet.getLong("CodigoDeBarra");
				int colunaQuantidade = resultSet.getInt("Quantidade");
				Double colunaValor = resultSet.getDouble("valor");
				
				//Codigo que lista para o usuario em forma de mensaggem
				System.out.println("ID: " + colunaid + " Nome: " + colunaNome + " Codigo de Barra: " + colunaCodBarra + " Quantidade: " + colunaQuantidade + " valor: " + colunaValor);
				 
				
			}
			
		}catch(SQLException e){
			
			//codigo de erro, caso de erro ao lista o produto
			System.out.println("erro ao Listar Produtos" + e.getMessage());
			
		}
		
		
	}

	
	//Metodo para Deletar produtos
	public void DeletarProduto(Produtos produto , int id) {
		
		//Linha de Codigo SQL
		String sql = " DELETE FROM produtos WHERE idProdutos = ? ";
		
		//Metodo para preparar o Codigo SQL
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		try {
			
			//Codigo para Abrir a Conexao e preparar o condigo SQL
			ps = conexao.getConexao().prepareStatement(sql);
			
			//Setando o id no comando SQL; 
			ps.setInt(1,id);
			//Codigo para executar o comando SQL.
			ps.execute();
			// Executa comando SQL para contagem de Registro.
			 String updateQuery = "SET @counter = 0";
	            	ps2 = conexao.getConexao().prepareStatement(updateQuery);
	            	ps2.executeUpdate();
	            	//Executa o comando SQL para fazer o update dos IDs e reaorganizar
	            	updateQuery = "UPDATE produtos SET idProdutos = @counter := @counter + 1";
	            	ps2 = conexao.getConexao().prepareStatement(updateQuery);
	            	ps2.executeUpdate();

	            ps2.close();
	            ps.close();
	            
		}catch (SQLException e) {
				
			//Mensagem de erro ao Deletar Dados
				System.out.println("erro ao deletar dados"	+ e.getMessage());
			
			}
		}
	
	
	public void ListarProdutos(Produtos produto, int id){
		
		//Linha de Codigo SQL
		String sql =" SELECT * FROM produtos WHERE idProdutos =  ? ";
		
		//Metodo que prepara o comando SQL
		PreparedStatement ps = null;
		
		try {
			
			//Abrindo conexão e preparando o codigo SQL
			ps = conexao.getConexao().prepareStatement(sql);
			
			//setando o ID para filtrar o camando SQL
			ps.setInt(1, id);
			
			//Metodo que mostra os resultados em um array;
			ResultSet resultSet = ps.executeQuery();
			
			// COdigo para listagem de uma array
			while(resultSet.next()){
				
				//codigo para pegar as informações do banco de dados e jogar nas variaveis para fazer o listamento
				int colunaid = resultSet.getInt("idProdutos");
				String colunaNome = resultSet.getString("Nome");
				Long colunaCodBarra = resultSet.getLong("CodigoDeBarra");
				int colunaQuantidade = resultSet.getInt("Quantidade");
				Double colunaValor = resultSet.getDouble("valor");
				
				//Codigo que lista para o usuario em forma de mensaggem
				System.out.println("ID: " + colunaid + " Nome: " + colunaNome + " Codigo de Barra: " + colunaCodBarra + " Quantidade: " + colunaQuantidade + " valor: " + colunaValor);
				
			}
			
		}catch(SQLException e){
			
			//codigo de erro, caso de erro ao lista o produto
			System.out.println("erro ao Listar Produtos" + e.getMessage());
			
		}
		
		
	}

}