package javaPojo;

public class EmpWithSpouse 
{
	


	public EmpWithSpouse() 
	{
		super();
	}


	String name;
	String rolNum;
	String email;
	int[] mobile;
    Object Spouse;

	public EmpWithSpouse(String name, String rolNum, String email, int[] mobile,Object Spouse) 
	{
		
		this.name = name;
		this.rolNum = rolNum;
		this.email = email;
		this.mobile = mobile;
		this.Spouse= Spouse;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRolNum() {
		return rolNum;
	}


	public void setRolNum(String rolNum) {
		this.rolNum = rolNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int[] getMobile() {
		return mobile;
	}


	public void setMobile(int[] mobile) {
		this.mobile = mobile;
	}


	public Object getSpouse() {
		return Spouse;
	}


	public void setSpouse(Object spouse) {
		Spouse = spouse;
	}



}
