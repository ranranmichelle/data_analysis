package data;

import java.util.*;


//Definite the properties of the students

public class Student{

	private int student_ID;
	private HashSet<Session> sessionSet;
   
	//basic information of students	
	public Student(int s_ID){
		this.student_ID = s_ID;
		this.sessionSet = new HashSet<Session>();
	}
	
	public int get_sID () {
		return this.student_ID;
	}
	
	public HashSet<Session> get_sessions(){
		return this.sessionSet;
	}
	
	public void add_session (Session ses) {
		this.sessionSet.add(ses);
	}

}

