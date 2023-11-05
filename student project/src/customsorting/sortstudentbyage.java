package customsorting;

import java.util.Comparator;
import sdbms.Student;

public class sortstudentbyage implements Comparator<Student> 
{
 @Override
 public int compare(Student x,Student y)
 {
	 return x.getage()-(y.getage());
 }
	
}
