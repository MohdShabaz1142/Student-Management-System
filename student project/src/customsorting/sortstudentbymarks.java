package customsorting;

import java.util.Comparator;
import sdbms.Student;

public class sortstudentbymarks  implements Comparator<Student>
{

	 @Override
	 public int compare(Student x,Student y)
	 {
		 return x.getmarks()-(y.getmarks());
	 }
		
	}

