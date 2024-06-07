package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class JdbcConn
 */
public class JdbcConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcConn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String s1 =          config.getInitParameter("driver");
 	   try {
		Class.forName(s1);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	                     String s2= config.getInitParameter("url");
 	                     String s3 = config.getInitParameter("username");
 	                     String s4 = config.getInitParameter("password");
 	            try {
					Connection conn = DriverManager.getConnection(s2, s3, s4) ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
 	            System.out.println("sucessful");
	}

}
