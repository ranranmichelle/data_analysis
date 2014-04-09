package data;

import java.util.*;


//Definite the properties of the students

public class student{

	private int student_ID;
	private HashSet<session> sessionSet;
   
	//basic information of students	
	public student(int s_ID){
		this.student_ID = s_ID;
		this.sessionSet = new HashSet<session>();
	}
	
	public int get_sID () {
		return this.student_ID;
	}
	
	public HashSet<session> get_sessions(){
		return this.sessionSet;
	}
	
	public void add_session (session ses) {
		this.sessionSet.add(ses);
	}

}

