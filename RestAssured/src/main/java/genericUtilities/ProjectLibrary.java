package genericUtilities;

public class ProjectLibrary {

	public ProjectLibrary()
	{
		super();
	}
	
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	public ProjectLibrary(String createdBy, String projectName, String status,int teamSize) {
		super();
		this.createdBy= createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}
	
	public int getTeamSize() {
		return teamSize;
	}
	
}
