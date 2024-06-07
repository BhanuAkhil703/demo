package Basics;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class JdbcConn
 */
@WebServlet("/JdbcConn")
public class JdbcConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JdbcConn() {
        super();
        
    }

	
    public void init(ServletConfig config) throws Throwable
    {
    	   String s1 =          config.getInitParameter("driver");
    	   Class.forName(s1);
    	                     String s2= config.getInitParameter("url");
    	                     String s3 = config.getInitParameter("username");
    	                     String s4 = config.getInitParameter("password");
    	            Connection conn = DriverManager.getConnection(s2, s3, s4) ; 
    	            System.out.println("sucessful");
    }

}
