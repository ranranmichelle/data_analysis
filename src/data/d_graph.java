package data;

import java.util.*;

//generate the graph based on the dataset

public class d_graph {

	private HashSet<student> studentSet;
	private HashSet<session> sessionSet;
	
	public d_graph () {
		this.studentSet = new HashSet<student>();
		this.sessionSet = new HashSet<session>();
	}
	
	public HashSet<session> get_sessions(){
		return this.sessionSet;
	}
	
	public HashSet<student> get_students(){
		return this.studentSet;
	}
	
	public void add_student (student s) {
		this.studentSet.add(s);
	}
	
	public void add_session (session se) {
		this.sessionSet.add(se);
		
	}
}

