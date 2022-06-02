import java.io.*;
import java.util.*;

public class NotAmused
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int currDay = 0;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			if(line.contains("OPEN"))
			{
				bw.write("Day " + (++currDay) + "\n");
			}
			
			else if(line.contains("ENTER"))
			{
				String[] parts = line.split(" ");
				String name = parts[1];
				int time = Integer.parseInt(parts[2]);
				Customer test = findByName(name, customers);
				if(test == null)
				{
					customers.add(new Customer(name, time));
				}
				else
				{
					test.enterTime = time;
				}
			}
			else if(line.contains("EXIT"))
			{
				String[] parts = line.split(" ");
				String name = parts[1];
				int time = Integer.parseInt(parts[2]);
				Customer cust = findByName(name, customers);
				cust.bill += 0.1d*(time-cust.enterTime);
			}
			else if(line.contains("CLOSE"))
			{
				Collections.sort(customers, new CustomerComparator());
				for(Customer c: customers)
					bw.write(c.name + " " + "$" + String.format("%.2f", c.bill) + "\n");
				bw.write("\n");
				
				customers.clear();
			}
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
	
	static Customer findByName(String name, ArrayList<Customer> customers)
	{
		for(Customer c: customers)
			if(c.name.equals(name))
				return c;
		return null;
	}
}

class Customer
{
	String name;
	int enterTime;
	double bill = 0.0d;
	
	Customer (String _name, int _time)
	{
		name = _name;
		enterTime = _time;
	}
}

class CustomerComparator implements Comparator<Customer>
{
	public int compare(Customer o1, Customer o2)
	{
		return o1.name.compareTo(o2.name);
	}
}
