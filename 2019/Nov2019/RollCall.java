import java.io.*;
import java.util.*;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class RollCall
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Student> students = new ArrayList<Student>();
		
		ArrayList<String> uniqueFirstNames = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			String[] name = line.split(" ");
			String first = name[0];
			String last = name[1];
			
			Student s = new Student(first, last);
			students.add(s);
			
			if(!uniqueFirstNames.contains(first))
			{
				uniqueFirstNames.add(first);
			}
			else
			{
				uniqueFirstNames.remove(first);
			}
			
			line = br.readLine();
		}
		
		Collections.sort(students, new StudentComparator());
		
		for(Student s: students)
		{
			if(uniqueFirstNames.contains(s.firstName))
			{
				bw.write(s.firstName + "\n");
			}
			else
			{
				bw.write(s.firstName + " " + s.lastName + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}

class Student
{
	String firstName;
	String lastName;
	
	Student(String first, String last)
	{
		firstName = first;
		lastName = last;
	}
}

class StudentComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		if(s1.lastName.equals(s2.lastName))
		{
			return s1.firstName.compareTo(s2.firstName);
		}
		else
		{
			return s1.lastName.compareTo(s2.lastName);
		}
	}
}
