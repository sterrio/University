// Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

public class PrintQueue {
	
	private GenericQueue <Job> Q;
	public PrintQueue(){
		Q = new GenericQueue<Job>(); 
	}
	
	//pushes job onto the queue with specified attributes.
	public void lpr(String owner, int jobId){
		Job e = new Job(owner, jobId);
		Q.enqueue(e);
	}
	
	//Loops through queue and prints out jobs with 
	public void lpq(){for (int i = 0; i < Q.size(); i++){
		
		if (i == 0)System.out.println(Q.first());
		else System.out.println(Q.next());
		
		}
	}
	
	// If the first owner value is eaual to the indicated one, remove it.
	public void lprm(int jobId){if (jobId == Q.first().getJobId()){
		Q.remove(Q.first());
		}
	}
	
	//loops through queue and compares owner values for each one, if they are equal, remove it.
	public void lprmAll(String owner){
		
		for(int i = 0; i < Q.size(); i++){
			if (i == 0){
				if(Q.first().getOwner().equals(owner)) Q.remove(Q.first());
			}
			else{
				Job j = Q.next();
				if (j.getOwner().equals(owner)) Q.remove(j);
			}
		}
	}
}
