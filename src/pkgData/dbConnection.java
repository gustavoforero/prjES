/*
 *Clase que permite la conexión a la Base de datos.
 */
package pkgData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kiritoxcii
 */
public class dbConnection {
    
    static String db = "Base del Conocimiento";
	static String login = "root";
	static String password = "12345";
	static String url = "jdbc:mysql://localhost/" + db;
    
        Connection connection = null;
        
        	public dbConnection() {
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
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}
}
