package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class dbTest
 */
@WebServlet("/dbTest")
public class dbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		        // TODO Auto-generated method stub
		        Connection conn = null;
		        Statement stmt = null;
		        try {
		            Class.forName("org.mariadb.jdbc.Driver");

		            System.out.print("Connecting to DB...");
		            conn = DriverManager.getConnection("jdbc:mariadb://localhost/mysql", "root", "");
		            System.out.println("done.");

		            stmt = conn.createStatement();
		            String sql = "SELECT user, host from mysql.user";
		            ResultSet hrs = stmt.executeQuery(sql);

		            while (hrs.next()) {
		                String user = hrs.getString(1);
		                String host = hrs.getString(2);
		                System.out.println("User: " + user + " Host: "+ host);
		            }
		        } catch (SQLException se) {
		            //Handle errors for JDBC
		            se.printStackTrace();
		            System.out.println("error1");
		        } catch (Exception e) {
		            //Handle errors for Class.forName
		            e.printStackTrace();
		            System.out.println("error2");
		        } finally {
		            //finally block used to close resources
		            try {
		                if (stmt != null) {
		                    conn.close();
		                }
		            } catch (SQLException se) {
		            }// do nothing
		            try {
		                if (conn != null) {
		                    conn.close();
		                }
		            } catch (SQLException se) {
		                se.printStackTrace();
			            System.out.println("error3");
		            }//end finally try
		        }//end try
		        System.out.println("Good bye!");

	}


}
