package dk.tec.jv.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jv2.AnalyzeRequest;
import dk.tec.jv2.Elev;



@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public HelloServlet() {}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Elev e1 = new Elev(1000, "tobias", 23, "IT");
		e1.addSkill("Stole sidder");
		
		Elev e2 = new Elev(1001, "Peter", 45, "Java");
		e2.addSkill("Stole ldawkopdawkpo");
		
		Elev e3 = new Elev(1002, "soren", 20, "Computer");
		e3.addSkill("Stole sidder");
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Elev> elever = new ArrayList<Elev>();
		elever.add(e1);
		elever.add(e2);
		elever.add(e3);
		String eJson = mapper.writeValueAsString(elever);
		
		AnalyzeRequest ar = new AnalyzeRequest(request.getPathInfo());
        
        switch(ar.getLevel()) 
        {
        	case MatchElevId:
        		for (var elev : elever) 
        		{ 
        			if(elev.getId() == ar.getId()) 
        			{
        				out.println(mapper.writeValueAsString(elev));
        			}       		 
        		}
        		
        		break;
        	case MatchElev:
        		out.println("elever" + mapper.writeValueAsString(elever));
        		break;
        	case MatchNo:
        		out.println("Uden ID");
        		break;
        }	
	}
}
