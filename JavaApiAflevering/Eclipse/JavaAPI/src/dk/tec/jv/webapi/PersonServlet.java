package dk.tec.jv.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jv2.DBTools;
import dk.tec.jv2.AnalyzeRequest;
import dk.tec.jv2.Person;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Person person;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		DBTools db = new DBTools();
		Person p;
		
		AnalyzeRequest ar = new AnalyzeRequest(request.getPathInfo());
		
		switch(ar.getLevel()) 
        {
        	case MatchPersonId:
        		p = db.GetPersonByID(ar.getId());
        		out.println(mapper.writeValueAsString(p));
        		break;
        	case MatchPerson:
        		ArrayList<Person> personer = db.GetPersons();
        		out.println(mapper.writeValueAsString(personer));
        		break;
        	case MatchNo:
        		out.println("Uden ID");
        		break;
        }	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBTools db = new DBTools();
			
		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		Person p = mapper.readValue(json, Person.class);
		
		db.PostPerson(p);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBTools db = new DBTools();
		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		Person p = mapper.readValue(json, Person.class);
		
		db.PutPerson(p);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBTools db = new DBTools();
		Person p;
		
		AnalyzeRequest ar = new AnalyzeRequest(request.getPathInfo());
		
		switch(ar.getLevel()) 
        {
        	case MatchPersonId:        		
        		db.DeletePerson(ar.getId());  
        		System.out.println("Deleted " + ar.getId());
        		break;
        	
        	case MatchNo:
        		System.out.println("Uden ID");
        		break;
        }
		
		/*
		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper();
		Person p = mapper.readValue(json, Person.class);
		
		db.DeletePerson(p.id);
		*/
	}

}
