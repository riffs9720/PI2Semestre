/*Connection DataBase Class*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{

   public Connection conectar() throws SQLException{
	   Connection connection = null; 
	   
	   try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         /* Configura os parâmetros da conexão */  
	         String url = "jdbc:mysql://localhost/sistemadesugestoes";  
	         String username = "dev";   
	         String password = "009720@tHena";  
	           
	         /* Tenta se conectar */  
	         connection = DriverManager.getConnection(url, username, password);  

	         /* Caso a conexão ocorra com sucesso, a conexão é retornada */  
	         return connection;
	      } 
	      catch (ClassNotFoundException e) {
	         throw new RuntimeException(e);
	      }
	   }
   
   public static void desconectar(Connection conn) throws SQLException {
      conn.close();
   }
}