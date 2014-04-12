package data;

import java.util.*;

//Definite the propoties of the sessions.

public class Session {
  private int session_start_time;
  private int session_duration;
  private int session_ID;
  private int num_of_students;
  private HashSet<Student> studentSet;
  
  //the propoties of the sessions
  public Session(int se_start_time, int se_duration, int se_ID, int num){
  	this.session_start_time = se_start_time;
  	this.session_duration = se_duration;
  	this.session_ID = se_ID;
  	this.num_of_students = num;
  	this.studentSet = new HashSet<Student>();
	}
  
  public int get_start_time () {
		return this.session_start_time;
	}
	
	public int get_duration(){
		return this.session_duration;
	}
	
	public int get_seID(){
		return this.session_ID;
	}
	
	public int get_num(){
		return this.num_of_students;
	}
	
	public HashSet<Student> get_sessions(){
		return this.studentSet;
	}
	
	public void add_student (Student stu) {
		this.studentSet.add(stu);
	}
}


