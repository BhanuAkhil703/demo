package Basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegistrationDemo
 */
@WebServlet("/Registration")
public class RegistrationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    
    public RegistrationDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","bhanu");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void destroy() 
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			PreparedStatement statement = con.prepareStatement("insert into admin values(?,?,?,?,?,?");
			statement.setString(1, req.getParameter("aname"));  
			statement.setString(2, req.getParameter("apwd"));
			statement.setString(3, req.getParameter("afname"));  
			statement.setString(4, req.getParameter("alname"));  
			statement.setString(5, req.getParameter("amail"));
			statement.setString(6, req.getParameter("aphno"));  
			statement.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			writer.println("Successful");
			writer.println("<html><body bgcolor=blue>Suceesfully registered</body></html>");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
