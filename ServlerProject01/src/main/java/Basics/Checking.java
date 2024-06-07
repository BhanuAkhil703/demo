package Basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Checking
 */
@WebServlet("/Login")
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
	                          }
	                          else
	                          {
	                        	  pw.println("invalid password");
	                          }
	                                      
			  
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	}

}
