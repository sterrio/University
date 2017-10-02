
public class Job {
	
	private String owner;
	private int jobId;
	public Job(String o, int j){
		
		owner = o;
		jobId = j;
	}
	public String getOwner(){
		return owner;
	}
	public int getJobId() {
		return jobId; 
	}
	
	//Adding toString function to be able to correctly print in PrintQueue class.
	public String toString(){ return owner + "\t " + jobId;}
}
