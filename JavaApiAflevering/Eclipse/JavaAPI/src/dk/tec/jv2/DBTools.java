package dk.tec.jv2;

import java.io.Console;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import dk.tec.jv2.Person;

public class DBTools 
{
	private String conUrl = "jdbc:sqlserver://LAPTOP-K2H8V51L;databaseName=JavaApiDB";
	
	private Connection conn;
	private Statement stmt;

	private void connect() 
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(conUrl, "sa", "1234");
			
			stmt = conn.createStatement();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Person> GetPersons()
	{
		connect();
		
		String selectSQL = "Select * from Person";
		ArrayList<Person> person = new ArrayList<Person>();
		Person p;
		
		try {
			ResultSet result = stmt.executeQuery(selectSQL);
			while(result.next()) 
			{
				p = new Person();
				p.setId(result.getInt("Id"));
				p.setName(result.getString("Name"));
				p.setJob(result.getString("Job"));
				p.setYearOfBirth(result.getInt("yearOfBirth"));
				p.setDriversLicense(result.getBoolean("DriversLicense"));
				p.setGender(result.getString("Gender"));
				p.setRelationshipStatus(result.getString("RelationShipStatus"));
				person.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return person;
	}
	
	public Person GetPersonByID(int id) 
	{
		connect();
		
		Person p = new Person();
		
		String selectSQL = "Select * from Person where id = " + id;
		
		try {
			ResultSet result = stmt.executeQuery(selectSQL);
			if(result.next()) 
			{
				p.setId(result.getInt("Id"));
				p.setName(result.getString("Name"));
				p.setJob(result.getString("Job"));
				p.setYearOfBirth(result.getInt("yearOfBirth"));
				p.setDriversLicense(result.getBoolean("DriversLicense"));
				p.setGender(result.getString("Gender"));
				p.setRelationshipStatus(result.getString("RelationShipStatus"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void PostPerson(Person p)
	{
		connect();
		int trueOrFalse;
		if( p.driversLicense)
		{
			trueOrFalse = 1;
		}
		else 
		{
			trueOrFalse = 0;
		}
		
		String PostSql = String.format("insert into Person values('%s', '%s', %s, %s, '%s', '%s')",
										p.name, p.job, p.yearOfBirth, trueOrFalse, p.gender, p.RelationshipStatus);
		System.out.println(trueOrFalse);
		try {
			stmt.execute(PostSql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void PutPerson(Person p) 
	{
		connect();
		int trueOrFalse;
		if( p.driversLicense)
		{
			trueOrFalse = 1;
		}
		else 
		{
			trueOrFalse = 0;
		}
		
		String PutSql = String.format("	update Person "
									 	+ "set name = '%s', job = '%s', yearOfBirth = %s, driversLicense = %s, gender = '%s', RelationshipStatus = '%s'"
									 	+ "where id = " + p.id, 
									 	p.name, p.job, p.yearOfBirth, trueOrFalse, p.gender, p.RelationshipStatus) ;
		System.out.println(PutSql);
		
		try {
			stmt.execute(PutSql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeletePerson(int id)
	{
		connect();
		
		String DelSql = "Delete from Person where id = " + id;
		
		try {
			stmt.execute(DelSql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

