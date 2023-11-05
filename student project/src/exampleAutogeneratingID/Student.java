package exampleAutogeneratingID;

class Student 
{
	String id;

	static int count=101;//declare a static counter variable

	Student() 
	{
		this.id="jsp"+count; //2.initialize the counter variable
		count++;//3.increment the counter variable 
	}
	public static void main(String[] args)
	{

		Student s1= new Student();
		Student s2= new Student();
		Student s3= new Student();

		System.out.println(s1.id);
		System.out.println(s2.id);
		System.out.println(s3.id);

	}
}
