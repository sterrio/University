//Lab 4 - Algorithm Complexity, October 10th 2017, Stephen Terrio B00755443.

public class Student {
	
	private int studentID;
	private String firstName;
	private String lastName;
	private String Semail;
	private String Facull;
	private String maj;

	public Student(String fN, String lN, String email, String major, String Faculty, int sId) {
		
		this.firstName = fN;
		this.lastName = lN;
		this.Semail = email;
		this.Facull = Faculty;
		this.maj = major;
		this.studentID = sId;
		
	}
	
	 //writing getters
	public String getfN(){return firstName;}
	public String getlN(){return lastName;}
	public String getemail(){return Semail;}
	public String getFaculty(){return Facull;}
	public String getmajor(){return maj;}
	public int getsId(){return studentID;}
	
	
	
	
}
