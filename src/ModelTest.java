import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rclgroup.dolphin.web.utils.EncryptDecryptUtil;

public class ModelTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	

		try {
	        Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	        System.err.println("Where is your PostgreSQL JDBC Driver? "
	                + "Include in your library path!");
	        e.printStackTrace();
	    }

	    try {
	       Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
	       

			 Statement stm =connection.createStatement();
			 ResultSet rs = stm.executeQuery("select user_id, pswd from esm_user_login");
			 while(rs.next()) {
				 //System.out.println(rs.getString("pswd"));
				 String p= rs.getString("pswd");
				 String conbert=EncryptDecryptUtil.convertHexToString(p);
				 if(conbert.length()>20) {
					 System.out.println(rs.getString("user_id"));
				 }
				 //System.out.println(conbert);
			 }
			 
	    } catch (SQLException e) {
	        System.err.println("Connection Failed! Check output console");
	        e.printStackTrace();
	    }

	    
	}

}
