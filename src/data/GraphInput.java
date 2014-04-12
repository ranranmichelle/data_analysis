package data;

import java.io.*;
import java.util.*;

//Generate a graph from the dataset.

public class GraphInput {

    public static void LoadGraph(D_graph newgraph, String pathandfilename){
        BufferedReader  inbuf = InputLib.fopen(pathandfilename);
        System.out.println("Opened " + pathandfilename + " for input.");
        String  line = InputLib.getLine(inbuf); // get first line
        StringTokenizer sTok;
        D_graph sg = newgraph;

        sTok = new StringTokenizer(line);
        int session_num = Integer.parseInt(sTok.nextToken());
        //int student_number = Integer.parseInt(sTok.nextToken());
        sTok.nextToken();
        HashMap<Integer, Student> studentSet = new HashMap<Integer, Student>();
        
        for (int i = 0; i < session_num; i++) {
        	line = InputLib.getLine(inbuf);
        	sTok = new StringTokenizer(line);
        	int session_start_time = Integer.parseInt(sTok.nextToken());
        	int session_ID = Integer.parseInt(sTok.nextToken());
        	int num_of_students = Integer.parseInt(sTok.nextToken());
        	int session_duration = Integer.parseInt(sTok.nextToken());
        	Session ses = new Session(session_start_time, session_duration, session_ID, num_of_students);
        	sg.add_session(ses);
        	line = InputLib.getLine(inbuf);
        	sTok = new StringTokenizer(line);
        	for (int j = 0; j < num_of_students; j++) {
        		int student_ID = Integer.parseInt(sTok.nextToken());
        		if (!studentSet.containsKey(student_ID)) {
        			Student stu = new Student(student_ID);
        			studentSet.put(student_ID, stu);
        			sg.add_student(stu);
        		}
        		Student stu = studentSet.get(student_ID);
        		ses.add_student(stu);
        		stu.add_session(ses);
        	}
        }
        InputLib.fclose(inbuf);
    }

    public static void main (String args[]) {
          D_graph G;
          G = new D_graph();
          LoadGraph(G, args[0]);
    }
}