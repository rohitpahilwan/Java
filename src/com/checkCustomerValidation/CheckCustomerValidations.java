package com.checkCustomerValidation;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.customerExceptionClass.CustomerExceptionClass;
import com.customerclass.Customer;
import com.customerclass.Plan;

public class CheckCustomerValidations {

	public static Plan checkPlan(String plancheck, double registrationAmount) throws CustomerExceptionClass {

		Plan plan = Plan.valueOf(plancheck.toUpperCase());
		if (plan.getPlancost() == registrationAmount)
			return plan;
		else
			throw new CustomerExceptionClass("INVALID PLAN...!!!");
	}

	public static void checkDuplicateEmail(String email, List<Customer> CustomerList) throws CustomerExceptionClass {
		Customer c = new Customer(email);
		if (CustomerList.contains(c))
			throw new CustomerExceptionClass("Account already registered !!! Try with different email id...");
	}

	public static void checkDuplicateEmailDob(String email, String dob, List<Customer> customerlist)
			throws CustomerExceptionClass {
		Customer newCustomer = new Customer(email);
		int index = (customerlist.indexOf(newCustomer));
		if (index == 0) {
			Customer chkIndex = newCustomer;
			if ((chkIndex.getDob()).equals(LocalDate.parse(dob)))
				throw new CustomerExceptionClass("Duplicate Email And Date of Birth");
		} 

	}

	public static Customer checkAllValidation(String FirstName, String Last_name, String email, String Password,
			String dob, double RegistrationAmount, String plann, List<Customer> CustomerList)
			throws CustomerExceptionClass {
//		checkDuplicateEmailDob(email, dob, CustomerList);
		Plan planf = checkPlan(plann, RegistrationAmount);
		
		findAge(dob);

		checkDuplicateEmail(email, CustomerList);
		
		checkRegexp(Password);

		LocalDate DOB = LocalDate.parse(dob);
		
		

		return new Customer(FirstName, Last_name, email, Password, DOB, RegistrationAmount, planf);
	}

	public static void checkSignIn(String email, String pass, List<Customer> customerList)
			throws CustomerExceptionClass {
		Customer c = new Customer(email);

		if (customerList.contains(c)) {
			// 1.indexOf
			// 2.Invalid email:throw custom Exception
			// 3.Contains not useful---returns boolean
			// 4.public int indexOf(Object o)
			int index = customerList.indexOf(c);
			Customer c1 = customerList.get(index);
			if (c1.getPassword().equals(pass)) {
				System.out.println("\n Successfully Login ");
				return;
			} else {
				System.out.println("\n Wrong Password");
			}

		}
		throw new CustomerExceptionClass("Wrong Email");

	}

	public static void unSubscribe(String email, String pass, List<Customer> customerlist)
			throws CustomerExceptionClass
	{
		Customer newCustomer = authtication.checkAuthentication(email, pass, customerlist);
		System.out.println(newCustomer);
		customerlist.remove(newCustomer);
		System.out.println("\n Succwsfully removed ");

	}

	public static void updatePassword(String email, String pass, List<Customer> customerlist)
			throws CustomerExceptionClass {
		Customer newCustomer = authtication.checkAuthentication(email, pass, customerlist);
		System.out.println("Enter the new password");
		Scanner sc = new Scanner(System.in);
		newCustomer.setPassword(sc.next());
		System.out.println("\n Password Successfully Updated... ");
	}
	public static List<Customer> populateCustomers() {
		Customer a1 = new Customer("Rutik", "Shinde",  "rutikshinde11@gmail.com" , "Rts@11" ,  LocalDate.parse("2000-10-11"),1000.0d , Plan.GOLD);


		Customer a2 = new Customer("Rohit", "Pahilwan",  "rohitpahilwan@gmail.com" , "Rohit@123" ,LocalDate.parse("2001-01-13"),2000 , Plan.GOLD);
		Customer a3 = new Customer("Sameer", "Shinde",  "sameer22@gmail.com" , "Rts@11" , LocalDate.parse("2001-01-13"),10000 , Plan.PLATINUM);
		Customer a4 = new Customer("Akshay", "Shinde",  "aks11@gmail.com" , "Rts@11" , LocalDate.parse("2001-01-13"),2000 , Plan.GOLD);
		Customer a5 = new Customer("Rahul", "Shinde",  "rahul11@gmail.com" , "Rts@11" ,LocalDate.parse("2001-01-13"),2000 , Plan.GOLD);
		Customer a6 = new Customer("Prashant", "Shinde",  "prashant11@gmail.com" , "Rts@11" , LocalDate.parse("1980-06-01"),2000 , Plan.GOLD);
		Customer a7 = new Customer("Abhishek", "Shinde",  "abhi@gmail.com" , "Rts@11" , LocalDate.parse("1999-04-21"),2000 , Plan.GOLD);
		
		Customer[] accts = { a1, a2, a3, a4, a5, a6, a7 };
		List<Customer> list = new ArrayList<>();	// up casting
		for (Customer a : accts)
			list.add(a);
		
		return list;
	}
	public static void checkRegexp(String pass) throws CustomerExceptionClass
	{
		String regchk="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if(pass.matches(regchk))
			System.out.println("Password Validation Successful ");	
		else
			throw new CustomerExceptionClass("Password must contains uppercase and Lowercase and atleast 1 Symbol ");
	}
	public static void findAge(String dob) throws CustomerExceptionClass
	{
		int age=Period.between(LocalDate.parse(dob),LocalDate.now() ).getYears();
		if(age<21)
		{
			throw new CustomerExceptionClass("You are not Allowed caz Age is lesst than 21");
		}
		else
		System.out.println("Age verification Successful ...Your age is "+age);
	}
	public static void removeAfterDate(String date,List<Customer> customerList) throws CustomerExceptionClass
	{
		Iterator<Customer> itr=customerList.iterator();
		LocalDate DOB=LocalDate.parse(date);
		int i=0;
		while(itr.hasNext())
		{
		
			Customer cs=itr.next();		
			if((cs.getDob()).isAfter(DOB))
			{
				System.out.println(cs.getDob());
				itr.remove();
				i=10;
			}
		}
//		if(i==10)
//			throw new CustomerExceptionClass("No date Found ");
//			
		}
}
