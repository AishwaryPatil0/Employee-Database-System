package CustomSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee>
{
	  @Override
	  public int compare(Employee e1, Employee e2)
	  
	  {
		  String x=e1.getName(); //Ai
		  String y=e2.getName(); //Bi
		  return x.compareTo(y); //return "Ai".compareTo("Bi");
		  //return e1.getName().compareTo(e2.getName());
	  }

}


