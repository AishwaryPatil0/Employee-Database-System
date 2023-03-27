package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomException.EmployeeNotFoundException;
import CustomException.InvalidChoiceException;
import CustomSorting.SortEmployeeByAge;
import CustomSorting.SortEmployeeById;
import CustomSorting.SortEmployeeByName;



public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {
	Scanner ip=new Scanner(System.in);
	Map<String,Employee> db=new LinkedHashMap<String,Employee>();

	@Override 
	public void addEmployee() 
	{
		System.out.println("Enter Employee Name: ");
		String name=ip.next();
		System.out.println("Enter Employee Age: ");
		int age=ip.nextInt();
		System.out.println("Enter Employee Salary: ");
		double salary=ip.nextDouble();
		Employee e=new Employee(age,name,salary);
		db.put(e.getId(), e);
		System.out.println("Employee Record Updated Successfully");
		System.out.println("Employee Id: "+e.getId());
	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter Employee Id to be Display: ");
		String id1=ip.next().toUpperCase();
		if(db.containsKey(id1))
		{
			System.out.println("Employee record found successfully!!");
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				System.out.println("Employee Details are as follows: ");
				Employee emp=db.get(id1);
				System.out.println(emp);
			}
		}
		else
		{
			try
			{
				String msg="Employee with the: "+id1+" not found in Database";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllEmployees() 
	{
		if(db.size()!=0)
		{
			System.out.println("Employee Details: ");
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				Employee emp=db.get(key);
				System.out.println(emp);
			}
		}
		else
		{
			try
			{
				String msg="Employee Database is empty";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void removeEmployee()
	{
		System.out.println("Enter Employee Id: ");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Employee Id found successfully!!");
			db.remove(id);
			System.out.println("Employee Id: "+id+"Removed Successfully..");
		}
		else
		{
			try
			{
				String msg="Employee with the: "+id+" not found in Database";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllEmployees() 
	{
		if(db.size()!=0)
		{
			System.out.println("Database Size: "+db.size());
			db.clear();
			System.out.println("Removed all the Records of Employee present in the Database");
			System.out.println("Database Size: "+db.size());
		}
		else
		{
			try
			{
				String msg="Employee Database is empty";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}


	@Override
	public void updateEmployee()
	{
		System.out.println("Enter Employee Id: ");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			Employee e=db.get(id);
			System.out.println("1:Update Name/n2:Upadate Age/n3:Update Salary/n4:Exit");
			System.out.println("Enter your choice: ");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name: ");
				String name=ip.next();
				e.setName(name);
				break;
			case 2:
				System.out.println("Enter Age: ");
				int age=ip.nextInt();
				e.setAge(age);
				break;
			case 3:
				System.out.println("Enter salary: ");
				Double salary=ip.nextDouble();
				e.setSalary(salary);
				break;
			case 4:
				System.out.println("Thank You!!");
				System.exit(0);
			default:
				try
				{
					throw new InvalidChoiceException("Invalid choice,Kindly enter valid choice!!");
				}
				catch(Exception m)
				{
					System.out.println(m.getMessage());
				}

			}			
		}
		else
		{
			try
			{
				String msg="Employee with the Id: "+id+" Not found in database";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countEmployee() 
	{
		if(db.size()!=0)
		{
			System.out.println("No of employee are: "+db.size());
		}
		else
		{
			try
			{
				String msg="Employee Database is empty";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void sortEmployees() 
	{
		if(db.size()>=2)
		{
			System.out.println("Database containing more than 2 records..");
			Set<String> keys=db.keySet();
			List<Employee> list=new ArrayList<Employee>();
			for(String key:keys)
			{
				Employee m=db.get(key);
				list.add(m);

			}
			System.out.println("1:Sort Employe By Id n/2:Sort Employe By name"
					+ " n/3:Sort Employe By Salary n/4:Sort Employe By Age n/5:Exit");
			System.out.println("Enter your choice: ");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:Collections.sort(list,new SortEmployeeById());
			display(list);
			break;
			case 2:Collections.sort(list,new SortEmployeeByName());
			display(list);
			break;
			case 3:Collections.sort(list,new SortEmployeeByName());
			display(list);
			break;
			case 4:Collections.sort(list,new SortEmployeeByAge());
			display(list);
			break;
			case 5:
				System.out.println("Thank You!!");
				System.exit(0);
			default:
				try
				{
					throw new InvalidChoiceException("Invalid choice,Kindly enter valid choice!!");
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
				String msg="Employee Database records are insufficient to Sort";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}
	private static void display(List<Employee> list)
	{
		System.out.println(list);
	}

	@Override
	public void getEmployeeWithHighestSalary() 
	{
		if(db.size()>=2)
		{
			Set<String> keys=db.keySet();
			List<Employee> list=new ArrayList<Employee>();
			for(String key:keys)
			{
				Employee emp=db.get(key);
				list.add(emp);
			}
			Collections.sort(list,new SortEmployeeByName());
			System.out.println(list.get(db.size()-1));
		}
		else
		{
			try
			{
				String msg="Employee Database records are insufficient to declare Highest Salary";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}


	}

	@Override
	public void getEmployeeWithLowestSalary() 
	{
		if(db.size()>=2)
		{
			Set<String> keys=db.keySet();
			List<Employee> list=new ArrayList<Employee>();
			for(String key:keys)
			{
				Employee emp=db.get(key);
				list.add(emp);
			}
			Collections.sort(list,new SortEmployeeByName());
			System.out.println(list.get(0));
		}
		else
		{
			try
			{
				String msg="Employee Database records are insufficient to declare Lowest Salary";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}

}