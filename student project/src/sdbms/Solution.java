package sdbms;

import customexception.InvalidChoiceException;

import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		System.out.println("welocme to student database management system");
		System.out.println("---------------------------------------------");


		Scanner sc= new Scanner(System.in);

		//upcasting with parent interface reference and implementation class object 
		StudentManagementSystem s= new StudentManagementSystemimpl();

		//infinite loop
		while(true)
		{

			System.out.println("1.addStudent\n2.displayStudent\n3.displayAllStudents\n4.removeStudent\n5.removeAllStudents\n6.updateStudent\n7.countStudents\n8.sortStudents\n9.getStudentWithHighestStudent\n10.getStudentWithLowestMarks\n11.exit");
			System.out.println("enter the choice:");
			int choice= sc.nextInt();

			//menu driven program
			switch(choice)
			{
			case 1:s.addStudent();
			break;
			case 2:s.displayStudent();
			break;
			case 3:s.displayAllStudents();
			break;
			case 4:s.removeStudent();
			break;
			case 5:s.removeAllStudents();
			break;
			case 6:s.updateStudent();
			break;
			case 7:s.countStudents();
			break;
			case 8:s.sortStudents();
			break;
			case 9:s.getStudentWithHighestMarks();
			break;
			case 10:s.getStudentWithLowestMarks();
			break;
			case 11:System.out.println("thank you");
			System.exit(0);
			break;

			default:
				try 
				{
					String message="invalidchoice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}


		}


	}
}
