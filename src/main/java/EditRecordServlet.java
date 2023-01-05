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
@WebServlet("/edit")
public class EditRecordServlet extends HttpServlet {

private final static String query ="update user set name=?,email=?,mobile=?,dob=?,department=?,gender=? where id=?";

	
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
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String dob=req.getParameter("dob");
		String department=req.getParameter("department");
		String gender=req.getParameter("gender");
	
        
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
        	ps.setString(1, name);
        	ps.setString(2, email);
        	ps.setString(3, mobile);
        	ps.setString(4, dob);
        	ps.setString(5, department);
        	ps.setString(6, gender);
        	ps.setInt(7, id);
        	//execute the query
        	int count =ps.executeUpdate();
        	pw.println("<div  class='card' style='margin:auto;width:300px;margin-top:100px>");
        	if(count==1) {
        		pw.println("<h2  class='bg-danger text-light text-center'>Record Edited Succesfully</h2>");
        	}
        	else {
        		
        		pw.println("<h2  class='bg-danger text-light text-center'>Record Not Edited</h2>");
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
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doGet(req,res);
	    }
}
