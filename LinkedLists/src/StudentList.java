
public class StudentList {
	
	private List<Student> students;
	
	//Creating a list of type student.
	public StudentList(){
		students = new List<Student>();
	}

		// Add or remove a student to the list
		public void add(Student st){students.add(st);}
		public void remove(Student st){students.remove(st);}
		
		// Searching list for all students of specified major
		public void printMaj(String major){
			if (students.first().getmajor().equals(major)); System.out.print(students.first());
			Student curs = students.next();
			
			while(curs != null){
				if (curs.getmajor().equals(major)); System.out.print(curs);
				curs = students.next();
			}
		}
		
		// Searching list for all students of specified faculty
		public void printfacull(String facull){
			if (students.first().getFaculty().equals(facull)); System.out.print(students.first());
			Student curs = students.next();
		
			while(curs != null){
				if (curs.getFaculty().equals(facull)); System.out.print(curs);
				curs = students.next();
			}
		}
		
		// Searching list for a student with specified ID
		public Student findID(int id){
			if (students.first().getsId() == id){ return students.first();}
			else{
				Student curs = students.next();
			while(curs != null){
				if (curs.getsId() == id) {return curs;}else{
					curs = students.next();
				}
				
			}
		}
			return null;
	}
		
		// Searching list for a student with specified first and last name 
		public Student findName(String fn, String ln){
			
			if (students.first().getfN().equals(fn) && students.first().getlN().equals(ln)) {return students.first();}
			else{
				Student curs = students.next();
			while (curs != null){
				if (curs.getfN().equals(fn) && curs.getlN().equals(ln)); return curs;
				}
			}
			return null;
		}
		
		// Searching list for a student with specified email address. 
		public Student findEmail(String email){
			if (students.first().getemail().equals(email)) {return students.first();}
			else{
				Student curs = students.next();
			while (curs != null){
				if (curs.getemail().equals(email)); return curs;
				}
			}
			return null;
		}	
	}
