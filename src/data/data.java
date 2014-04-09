package data;

import tools.*;
import java.util.*;

public class data {
	public static HashSet<session> Same_session(student student1,
			student student2) {
		HashSet<session> session1 = student1.get_sessions();
		HashSet<session> session2 = student2.get_sessions();
		HashSet<session> Same_session = new HashSet<session>(session1);
		Same_session.retainAll(session2);
		return Same_session;
	}

	public static int[] inter_contact_time(HashSet<session> Same_session) {
		int start_time_se[] = new int[Same_session.size()];
		int inter_contact_time[] = new int[Same_session.size()];
				
		int i = 0;
		for(session s: Same_session){
			start_time_se[i] = s.get_start_time();
			i++;
		}
		
		MergeSort.mergesort(start_time_se);
		for (int j = 0; j < start_time_se.length - 1; j++) {
			inter_contact_time[j] = start_time_se[j + 1] - start_time_se[j];
		}
		int T = 77;
		inter_contact_time[start_time_se.length - 1] = T + start_time_se[0]
				- start_time_se[start_time_se.length - 1];
		return inter_contact_time;
	}

	public static void main(String[] args) {
		d_graph graph1 = new d_graph();
		System.out.println("Please type in the path of the dataset:");
		String pathandfilename = KeyboardReader.readString();
		graphInput.LoadGraph(graph1, pathandfilename);
		HashSet<student> studentSet = graph1.get_students();
//		HashSet<session> sessionSet = graph1.get_sessions();

		HashMap<Integer, student> ID_to_student = new HashMap<Integer, student>();
		for (student s : studentSet)
			ID_to_student.put(s.get_sID(), s);

		System.out.println("Please choose the first student:");
		int s1_ID = KeyboardReader.readInt();
		student student1 = ID_to_student.get(s1_ID);

		System.out.println("Please choose the second student:");
		int s2_ID = KeyboardReader.readInt();
		student student2 = ID_to_student.get(s2_ID);

		HashSet<session> Same_session = data.Same_session(student1, student2);
		// Iterator<session> itersame = Same_session.iterator();
		// while(itersame.hasNext()){
		// System.out.println(itersame.next().get_seID());
		// }

		int inter_contact_time[] = data.inter_contact_time(Same_session);
		for (int i = 0; i < inter_contact_time.length; i++) {
			System.out.println(inter_contact_time[i]);
		}
	}
}
