package serializeAndDeserialize;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javaPojo.Employee;

public class EmployeeSerialization 
{
	public static void main(String[] args) throws Throwable, JsonMappingException, IOException 
	{
		int[] mobile= {1234,5677};
		Employee emp = new Employee("Srimanth", "Ty1207", "srimanth@tyss.com", mobile);
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.writeValue(new File("./emp.json"), emp);
	}

}
