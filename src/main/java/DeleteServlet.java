import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {
	
	private final static String query ="delete from user where id=?";

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//	Get Print write
PrintWriter pw=res.getWriter();
		
		//Set content type
		res.setContentType("text/html");
		
//		LINK THE BOOTSTRAP
		pw.println("<link rel='stylesheet'  href='css/bootstrap.css'></link>");
		
//		Get the values
		int id=Integer.parseInt(req.getParameter("id"));
        
        //Load jdbc driver
        try {
        	
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	

        }
        catch(Exception e) {
        	
        	e.printStackTrace();
        	
       
        	
        }
        //Generate the Connection
        try(Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usermgmt","root","miaelaa2017")) {
        	PreparedStatement ps=con.prepareStatement(query);
        	//set the values
        	ps.setInt(1, id);
        	//execute the query
        	int count =ps.executeUpdate();
        	pw.println("<div  class='card' style='margin:auto;width:300px;margin-top:100px>");
        	if(count==1) {
        		pw.println("<h2  class='bg-danger text-light text-center'>Record Deleted Succesfully</h2>");
        	}
        	else {
        		
        		pw.println("<h2  class='bg-danger text-light text-center'>Record Not Deleted</h2>");
        	}
        } catch (SQLException se) {
		
        	pw.println("<h2 class='bg-danger text-light text-center'>" +se.getMessage()+"</h2>");
			se.printStackTrace();
		}
        catch(Exception e) {
        	e.printStackTrace();
        }
        pw.print("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("&nbsp &nbsp");
        pw.print("<a <a href='showdata'> <button class='btn btn-outline-success display-block  '>Show Users</button></a>");
        pw.println("</div>");
        
//        Close the Stream
        pw.close();
        
		
	}
}