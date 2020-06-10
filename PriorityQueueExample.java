import java.util.*;

public class PriorityQueueExample {


	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());
		Student st1 = new Student("Shivraj", 90);
		Student st2 = new Student("Kedar", 85);
		Student st3 = new Student("nitin", 79);
		Student st4 = new Student("kalpesh", 93);
		Student st5 = new Student("amey", 90);
		pq.add(st1);
		pq.add(st2);
		pq.add(st3);
		pq.add(st4);
		pq.add(st5);

		//Iterator itr = pq.iterator();
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}


	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getGrade() < o2.getGrade())
			return 1;
		else if (o1.getGrade() > o2.getGrade())
			return -1;
		else
			return o1.getName().compareTo(o2.getName());
	}
}
