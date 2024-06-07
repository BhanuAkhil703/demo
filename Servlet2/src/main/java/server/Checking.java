package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checking
 */
@WebServlet("/Login2")
public class Checking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bhanu");
		                PreparedStatement ps = con.prepareStatement("select * from login where  ID=? and  PASSWORD=?");
		                                      String s1 = request.getParameter("uname");
		                                      String s2 = request.getParameter("pwd");
		                                      ps.setString(1, s1);
		                                      ps.setString(2, s2);
		                                      ResultSet rs = ps.executeQuery();
		                                      PrintWriter pw = response.getWriter();
		                          if(rs.next())
		                          {
		                        	  pw.println("welcome to servlet");
		                        	  response.setContentType("text/html");
		                        	  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		                        	  rd.include(request, response); 
		                          }
		                          else
		                          {
		                        	  pw.println("invalid password");
		                        	  response.setContentType("text/html");
		                        	  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		                        	  rd.include(request, response);
		                        	  
		                          }
		                                      
				  
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}// TODO Auto-generated method stub
	}

}
