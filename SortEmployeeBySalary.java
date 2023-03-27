package CustomSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2)

	{
		Double x=e1.getSalary(); //2.6
		Double y=e2.getSalary(); //2.7
		return x.compareTo(y); //return "2.6".compareTo("2.7");->+1
		//return e1.getSalary().compareTo(e2.getSalary());
	}

}
