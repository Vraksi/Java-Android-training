package dk.tec.jv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.tec.jv2.AnalyzeRequest;
/*

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public HelloServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
        out.println("ContextPath: " + request.getContextPath());
        out.println("<br />Servlet Path: " +request.getServletPath());
        out.println("<br />Path Info: "+ request.getPathInfo());
        out.println("<br /><br />");
        
        AnalyzeRequest ar = new AnalyzeRequest(request.getPathInfo());
        
        switch(ar.getLevel()) 
        {
        	case MatchElevId:
        		out.println("match elev id: " + ar.getId());
        		break;
        	case MatchElev:
        		out.println("match elev id: " + ar.getId());
        		break;
        	case MatchNo:
        		out.println("match elev id: " + ar.getId());
        		break;
        
        }
	}
}
*/