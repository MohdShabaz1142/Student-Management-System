package sdbms;
//bean class
public class Student
{
	private String id;
	private int age;
	private  String name;
	private int marks;

	/*if we make counter variable non static it will have  the multiple copies with the same value for every object so
	 * here we need to auto increment it so we make it as static cuz it will have only one copy thus it will increment with every object
	 */
	static int count=100;//static counter variable to auto increment the id


	public Student(int age,String name,int marks)
	{
		this.id="JSP"+count;
		count++;
		this.age= age ;
		this.name=name;
		this.marks=marks;
	}
	//public getters
	public String getid()
	{
		return id;
	}
	public int getage()
	{
		return age;
	}
	public String getname()
	{
		return name;
	}
	public int getmarks()
	{
		return marks;
	}

	//public setters
	//id is auto generated so it must not have setter method 

	public void setage(int age)
	{
		this.age=age;
	}
	public void setname(String name) 
	{
		this.name=name;
	}
	public void setmarks(int marks)
	{
		this.marks=marks;
	}
	
	
	
	@Override
	public String toString()
	{
		return "id:"+id+   "name:"+name+   "age:"+age+    "marks:"+marks;
	}





}
