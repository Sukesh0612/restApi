package serializeAndDeserialize;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

import javaPojo.Employee;

public class EmployeeDeserialiaze 
{
	public static void main(String[] args) throws JsonParseException, IOException, Throwable 
	{
		Employee emp = new Employee();
		ObjectMapper omap = new ObjectMapper();
		Employee s = omap.readValue(new File("./emp.json"), Employee.class);
		System.out.println(s.getEmail());
		System.out.println(s.getName());
		//int[] mobile= {1234,7777};
		System.out.println(s.getMobile()[0]);
		System.out.println(s.getMobile()[1]);
		
		



	}
}
