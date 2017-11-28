//Lab 3 - Data Structures and Algorithms, October 1st, 2017. Stephen Terrio, B00755443.

public class StudentRecord {

	//Creating variables to be used in constructor
	private String firstName;
	private String lastName;
	private int bannerID;
	
	//Creating a constructor for StudenRecords
	public StudentRecord(String fN, String lN, int bID){fN = firstName; lN = lastName; bID = bannerID;}
	
	//Getters
	public String getfN(){return firstName;}
	public String getlN(){return lastName;}
	public int getbID() {return bannerID;}
	
	//Setters
	public void setfN (String fN) {firstName = fN;}
	public void setlN (String lN) {lastName = lN;}
	public void setBId (int BId) {bannerID = BId;}
	
	// Returns Student Record object attributes.
	public String toString() {return firstName + " " + lastName + " " + bannerID;}
}
