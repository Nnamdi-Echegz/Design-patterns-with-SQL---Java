/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * this establishes a connection with the database
 */
public class DataSource {
    private Connection connection = null;
	/**
         * creats a new instance of the above DataScource class
         */
	public DataSource(){}

	public Connection createConnection(){
            // added use of Properties and try-with-resources
            Properties props = new Properties();

		try (InputStream in = Files.newInputStream(Paths.get("src/echegini/nnamdi/lab2/database.properties"));) {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
               /**
                * this is used to get the connection properties which a user(me) would provide to establish
                * a connection with my data base
                */
	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				connection = DriverManager.getConnection(url, username, password);
			}
		}
		catch(SQLException ex){
                    ex.printStackTrace();
		}
		return connection;
	}
}
