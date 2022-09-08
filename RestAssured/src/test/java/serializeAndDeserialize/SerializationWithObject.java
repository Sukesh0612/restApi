package serializeAndDeserialize;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javaPojo.EmpWithSpouse;
import javaPojo.Spouse;

public class SerializationWithObject {

	public static void main(String[] args) throws JsonGenerationException, IOException, Throwable 
	{
		int[] mobile= {7777, 9999};
		Spouse spouse = new Spouse("leela","leela@xyz.com",7896);
		EmpWithSpouse complex = new EmpWithSpouse("raj","tyss010","rajesh@abc.com", mobile, spouse);
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.writeValue(new File("./emp.json"), complex);


	}

}
