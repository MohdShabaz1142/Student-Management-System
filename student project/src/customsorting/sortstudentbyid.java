package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class sortstudentbyid implements Comparator<Student>
{
 @Override
 public int compare(Student x,Student y)
 {
	 return x.getid().compareTo(y.getid());
 }
	
}
