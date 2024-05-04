package com.checkCustomerValidation;
import java.util.List;
import com.customerExceptionClass.CustomerExceptionClass;
import com.customerExceptionClass.*;
import com.customerclass.Customer;


public class authtication {
	public static Customer checkAuthentication(String email,String pass,List<Customer> list) throws CustomerExceptionClass
	{
		Customer newCustomer=new Customer(email);
		int index=list.indexOf(newCustomer);
		
		if(index==-1)
		throw new CustomerExceptionClass("Incorrect email , Login Failed");
		
		Customer customer = list.get(index);
		if(customer.getPassword().equals(pass))
		return customer;
		
	  throw new CustomerExceptionClass("Incorrect Passowrd , Login Failed");	
	}

}
