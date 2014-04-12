package data;

import java.util.*;

//generate the graph based on the dataset

public class D_graph {

	private HashSet<Student> studentSet;
	private HashSet<Session> sessionSet;
	
	public D_graph () {
		this.studentSet = new HashSet<Student>();
		this.sessionSet = new HashSet<Session>();
	}
	
	public HashSet<Session> get_sessions(){
		return this.sessionSet;
	}
	
	public HashSet<Student> get_students(){
		return this.studentSet;
	}
	
	public void add_student (Student s) {
		this.studentSet.add(s);
	}
	
	public void add_session (Session se) {
		this.sessionSet.add(se);
		
	}
}

