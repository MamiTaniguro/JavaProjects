import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
	Connection conn;
	Statement st;
	
	private String db_url;
	private String db_name;
	private String db_user;
	private String db_password;
	private String db_host;
	private String db_port;
	private String db_driver;

	public Connector(Properties props, String pass) {
		db_name = props.getProperty("db_name");
		db_user = props.getProperty("db_user", "root");
		db_password = pass;
		db_host = props.getProperty("db_host");
		db_port = props.getProperty("db_port");
		db_driver = "com.mysql.cj.jdbc.Driver";
		db_url = "jdbc:mysql://"+db_host+":"+db_port+"/"+db_name+"?serverTimezone=UTC";
		
		System.out.println(db_url);
		
	}
	
	public boolean connect() {
		
		try {
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			
			st = conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (conn == null) {
				return false;
			}
			
			
		}
		
		System.out.println("Connected to the database");
		return true;
		
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return st.executeQuery(query);
	}

}
