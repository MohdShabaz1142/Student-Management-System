package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.*;

//implementation class
public class StudentManagementSystemimpl implements StudentManagementSystem
{
	Scanner sc= new Scanner(System.in);

	/*
	 * we are using collection as our database
	 * key is<string>-->student id & value is<student>-->student objects
	 */

	Map<String,Student> db= new LinkedHashMap();

	@Override
	public void addStudent()
	{

		System.out.println("accept age:");
		int age= sc.nextInt();
		System.out.println("accept name:");
		String name=sc.next();
		System.out.println("accept marks:");
		int marks= sc.nextInt();

		//creating student object
		Student s= new Student(age,name,marks);


		//adding student id as key and student object as value
		db.put(s.getid(),s);


		System.out.println("registered successfully");
		System.out.println("--------------------------"); 
		System.out.println("student id is:"+s.getid());
		System.out.println("--------------------------");




	}
	@Override
	public void displayStudent()
	{

		//accepting the id from user and converting it to upper case
		System.out.println("enter student id:");
		String id=sc.next();
		id=id.toUpperCase();


		if(db.containsKey(id))
		{
			System.out.println("student record found");
			Student std = db.get(id);//getting student object using key
			System.out.println("id:"+std.getid());
			System.out.println("age:"+std.getage());
			System.out.println("name:"+std.getname());
			System.out.println("marks:"+std.getmarks());	
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("student id not present");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}	





	}
	@Override
	public void displayAllStudents()
	{
		/*
		 * checking if the db is empty or not.
		 * if-->db is not empty  we will display students records(objects)
		 *else -->db is empty it throws an exception
		 */

		if(!db.isEmpty())
		{
			System.out.println("student records are as follows");
			System.out.println("-------------------------------");

			//converting map(db) into set
			Set<String> keys = db.keySet();//only keys it stores

			for(String key:keys)
			{
				//printing ref variable -->tostring overridden
				System.out.println("====================");
				System.out.println(db.get(key));
				System.out.println("====================");
			}
		}
		else 
		{
			try
			{
				throw new StudentNotFoundException("student records not found");
			}
			catch(Exception e)
			{
				System.out.println("====================");
				System.out.println(e.getMessage());
				System.out.println("=====================");
			}

		}	


	}

	@Override
	public void removeStudent() 
	{
		//accepting id from the user and converting it to uppercase
		System.out.println("enter student id:");
		String id=sc.next();
		id=id.toUpperCase();

		if(db.containsKey(id))
		{
			db.remove(id);
			System.out.println("student removed");

		}
		else
		{ 
			try 
			{
				throw new StudentNotFoundException("Student not found ");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}



	} 
	@Override
	public void removeAllStudents()
	{
		if(!db.isEmpty())
		{
			System.out.println("------------------------------------------------");
			System.out.println("no of student records before deleting:"  +db.size());
			System.out.println("------------------------------------------------");
			db.clear();
			System.out.println("------------------------------------------------");
			System.out.println("no of student records after deleting:"   +db.size());
			System.out.println("------------------------------------------------");
			System.out.println("student records deleted successfully");
			System.out.println("------------------------------------------------");
		}

		else 
		{
			try
			{
				String message="student records not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void updateStudent() 
	{
		System.out.println("enter the id");
		String id= sc.next().toUpperCase();
		if(db.containsKey(id)) 
		{   
			Student std=db.get(id);



			System.out.println("1.updateage\n2.update name\n3.update marks");
			System.out.println("enter the choice to update:");
			int choice=sc.nextInt();

			switch(choice)
			{

			case 1:System.out.println("enter the updating age");
			int age=sc.nextInt();
			std.setage(age);
			System.out.println("updated age is:"+age);
			break;

			case 2:System.out.println("enter the updating name");
			String name=sc.next();
			std.setname(name);
			System.out.println("updated name is:"+name);
			break;

			case 3:System.out.println("enter the updating marks");
			int marks=sc.nextInt();
			std.setage(marks);
			System.out.println("updated age is:"+marks);
			break;

			default:
				try
				{
					throw new  InvalidChoiceException ("invalid choice to update");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else 
		{
			try
			{
				throw new StudentNotFoundException("student not found to update");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}


		}


	}

	@Override
	public void countStudents()
	{ 
		System.out.println("number of student reords:"+db.size());

	}
	@Override
	public void sortStudents()
	{
		if(db.size()>=2)
		{
			//ref of list and objects of arraylist and storing student objects
			List<Student> l= new ArrayList();

			//converting the (DB)->map to set using keyset()
			Set<String> keys = db.keySet();

			//traversing keys(IDs)
			for(String key:keys)
			{
				Student std = db.get(key);//getting student objects using the key
				l.add(std);//adding student objects to arraylist
			}


			System.out.println("1.sortstudentbyID\n2.sortstudentbyage\n3.sortstudentbyname\n4.sortstudentbymarks");
			System.out.println("enter the choice to sort:");
			int choice =sc.nextInt();

			switch(choice)
			{
			case 1: Collections.sort(l,new sortstudentbyid());
			for(Student s:l)
			{
				System.out.println(s);
			}
			break;
			case 2: Collections.sort(l,new sortstudentbyage());
			for(Student s:l)
			{
				System.out.println(s);
			}
			break;

			case 3: Collections.sort(l,new sortstudentbyname());
			for(Student s:l)
			{
				System.out.println(s);
			}
			break;

			case 4: Collections.sort(l,new sortstudentbymarks());
			for(Student s:l)
			{
				System.out.println(s);
			}
			break;

			default: 
				try
				{
					throw new InvalidChoiceException("invalid choice to sort");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}


			}
		}
		else 
		{
			try
			{
				throw new StudentNotFoundException("no sufficient records to sort");	
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


	}
	@Override
	public void getStudentWithHighestMarks() 
	{
		List<Student>l=new ArrayList();

		Set<String> keys = db.keySet();


		for(String key:keys)
		{
			Student std=db.get(key);
			l.add(std);
		}
		Collections.sort(l,new sortstudentbymarks());
		System.out.println("student with highest marks:");
		System.out.println(l.get(l.size()-1));

	}
	@Override
	public void getStudentWithLowestMarks()
	{
		if(db.size()>=2)
		{
			List<Student>l=new ArrayList();

			Set<String> keys = db.keySet();


			for(String key:keys)
			{
				Student std=db.get(key);
				l.add(std);
			}
			Collections.sort(l,new sortstudentbymarks());
			System.out.println("student with lowest marks:");
			System.out.println(l.get(0));

		}
		else
		{
			try
			{
				throw new StudentNotFoundException("no sufficient records to sort on marks");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


}


