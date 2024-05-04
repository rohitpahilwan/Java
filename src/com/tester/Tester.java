package com.tester;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.sortcustomerlist.SortList;
import com.checkCustomerValidation.CheckCustomerValidations;
import com.checkCustomerValidation.authtication;
import com.customerExceptionClass.CustomerExceptionClass;
import com.customerclass.Customer;
import com.customerclass.Plan;
import com.sortcustomerlist.SortList;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			List<Customer> CustomerList = new ArrayList<>(); // size=0 : Capacity=10
			boolean exit = true;

				while (exit) {
					try {
					System.out.println("\n 1. for Sign Up \n 2. Display All Accounts \n 3. Sign-In \n 4. UnSubscribe \n 5. Update Password \n 6. Populated data \n 7. Sort with DOB \n 8. Sort with DOB And Last name \n 9. Check Password  /n 10. Find Age \n 11.Enter date to delete details After date");					
					System.out.println("\n Enter th Choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"\n 1.FirstName : \n2.Last_name : \n3.email :\n4.Password : \n5.DOB : \n6.RegistrationAmount : \n7.plan : ");
						Customer C1 = CheckCustomerValidations.checkAllValidation(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextDouble(), sc.next(), CustomerList);
						CustomerList.add(C1);
						System.out.println("Account Created...");
						break;
					case 2:
						for (Customer c : CustomerList) 
						{
							System.out.println(c);
						}
						break;
					case 3:
						System.out.println("\n Enter the email Id And Password For Login \n");
						
						Customer customer=authtication.checkAuthentication(sc.next(),sc.next(), CustomerList);
						System.out.println("\n Successfully Logged in");
						break;
					case 4 :
						System.out.println("\nEnter the email and Password ");
						CheckCustomerValidations.unSubscribe(sc.next(), sc.next(), CustomerList);
						break;
					case 5:
						System.out.println("\nEnter the email and Password ");
						CheckCustomerValidations.updatePassword(sc.next(), sc.next(), CustomerList);
						break;
					case 6:
						CustomerList=CheckCustomerValidations.populateCustomers();
						System.out.println("\n Populated Data has been added ");
						break;
					case 7:
						Collections.sort(CustomerList);
						break;
					case 8:
							Collections.sort(CustomerList,new SortList());
						break;
					case 9:
						System.out.println("\n Enter Password");
						CheckCustomerValidations.checkRegexp(sc.next());
						break;
					case 10:
						System.out.println("\nEnter the age");
						CheckCustomerValidations.findAge(sc.next());
					break;
					case 11:
						System.out.println("\n Enter the date ");
						CheckCustomerValidations.removeAfterDate(sc.next(), CustomerList);
						break;
					case 0:
						exit = false;
						break;
					default:
						System.out.println("\n Invalid Choice ");

					}
				}
			catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
			}
		}
	}
}
