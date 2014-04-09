package data;

import java.io.*;
import java.util.*;

//Generate a graph from the dataset.

public class graphInput {

    public static void LoadGraph(d_graph newgraph, String pathandfilename){
        BufferedReader  inbuf = InputLib.fopen(pathandfilename);
        System.out.println("Opened " + pathandfilename + " for input.");
        String  line = InputLib.getLine(inbuf); // get first line
        StringTokenizer sTok;
        d_graph sg = newgraph;

        sTok = new StringTokenizer(line);
        int session_num = Integer.parseInt(sTok.nextToken());
        //int student_number = Integer.parseInt(sTok.nextToken());
        sTok.nextToken();
        HashMap<Integer, student> studentSet = new HashMap<Integer, student>();
        
        for (int i = 0; i < session_num; i++) {
        	line = InputLib.getLine(inbuf);
        	sTok = new StringTokenizer(line);
        	int session_start_time = Integer.parseInt(sTok.nextToken());
        	int session_ID = Integer.parseInt(sTok.nextToken());
        	int num_of_students = Integer.parseInt(sTok.nextToken());
        	int session_duration = Integer.parseInt(sTok.nextToken());
        	session ses = new session(session_start_time, session_duration, session_ID, num_of_students);
        	sg.add_session(ses);
        	line = InputLib.getLine(inbuf);
        	sTok = new StringTokenizer(line);
        	for (int j = 0; j < num_of_students; j++) {
        		int student_ID = Integer.parseInt(sTok.nextToken());
        		if (!studentSet.containsKey(student_ID)) {
        			student stu = new student(student_ID);
        			studentSet.put(student_ID, stu);
        			sg.add_student(stu);
        		}
        		student stu = studentSet.get(student_ID);
        		ses.add_student(stu);
        		stu.add_session(ses);
        	}
        }
        InputLib.fclose(inbuf);
    }

    public static void main (String args[]) {
          d_graph G;
          G = new d_graph();
          LoadGraph(G, args[0]);
    }
}