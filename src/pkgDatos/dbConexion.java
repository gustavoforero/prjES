/*
 *Clase que permite la conexión a la Base de datos.
 */
package pkgDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kiritoxcii
 */
public class dbConexion {
    
    static String db = "Base del Conocimiento";
	static String login = "root";
	static String password = "12345";
	static String url = "jdbc:mysql://localhost/" + db;
    
        Connection connection = null;
        
        	public dbConexion() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
			
			if(connection != null){
				System.out.println("Conexión a la base de datos "+ db + " OK");
			}
		}catch( SQLException | ClassNotFoundException e){
			System.out.println(e);
		}
	
	}
	
	public Connection getConexion() {
		return connection;
	}
	
	public void desconectar() throws SQLException {
		connection.close();
	}
}
