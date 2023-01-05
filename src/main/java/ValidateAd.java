
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ValidateAd
 */

public class ValidateAd extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String un=request.getParameter("Ausername");  //Fetch Username
		String pw=request.getParameter("Apassword");  //Fetch password
		response.setContentType("text/html");
		
		//Sets of Admin username and password
		
		String u1="A101";
		String p1="1234";
		
		String u2="A102";
		String p2="5678";
		
		String u3="A103";
		String p3="ABCD";
		
		String u4="A104";
		String p4="abcd";
		
		
		//If - else to check entries
		
		if(pw.equals(p1) && un.equals(u1)) {
			
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			
		}
		else if(pw.equals(p2) && un.equals(u2)) {
			
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			
		}
		else if(pw.equals(p3) && un.equals(u3)) {
	
	        RequestDispatcher rd=request.getRequestDispatcher("home.html");
	        rd.forward(request, response);
	
}
		else if(pw.equals(p4) && un.equals(u4)) {
	
	       RequestDispatcher rd=request.getRequestDispatcher("home.html");
	       rd.forward(request, response);
	
}
		else {
			out.println("<center><h1>!! Please Enter Valid Username and Password !! </h1></center>");
			 RequestDispatcher rd=request.getRequestDispatcher("Alogin.html");
			 rd.include(request, response);
				
			
		}
		
		
		
		doGet(request, response);
	}

}
