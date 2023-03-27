package edbms;

import java.util.Scanner;

import CustomException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		EmployeeManagementSystem db=new EmployeeManagementSystemImpl();
		while(true)
		{
			System.out.println("1:AddEmployee\n2:DisplayEmployee\n3:"
					+ "DisplayAllEmployee\n4:RemoveEmployee\n5:RemoveAllEmployee\n6:"
					+ "UpdateEmployee\n7:CountEmployee\n8:SortEmployee\n9:"
					+ "GetEmployeeWithHighestMarks\n10:GetEmployeeWithLowestMarks\n11:Exit");
			System.out.println("Enter your choice: ");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:db.addEmployee();
			break;
			case 2:db.displayEmployee();
			break;
			case 3:db.displayAllEmployees();
			break;
			case 4:db.removeEmployee();
			break;
			case 5:db.removeAllEmployees();
			break;
			case 6:db.updateEmployee();
			break;
			case 7:db.countEmployee();
			break;
			case 8:db.sortEmployees();
			break;
			case 9:db.getEmployeeWithHighestSalary();
			break;
			case 10:db.getEmployeeWithLowestSalary();
			break;
			case 11:
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
			System.out.println("========================================================");
		}

	}

}