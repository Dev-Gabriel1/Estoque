
package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	private static final String url ="jdbc:mysql://localhost:3306/estoque";
	private static final String usuario = "root";
	private static final String senha ="root";
	
	
	private static Connection conn;
	
	public static Connection getConexao(){
		try {	
			
			if(conn == null) {
				
				conn = DriverManager.getConnection(url , usuario, senha);
				
				return conn;
				
			}else {
				
				return conn;
				
			}
		
		}catch (SQLException e) {
			System.out.println(" erro ao conectar");
			e.printStackTrace();
			return null;
		}
}
	
	

}
