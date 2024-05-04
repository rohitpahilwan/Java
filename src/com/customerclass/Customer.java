package com.customerclass;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Comparable<Customer>
{


	private static final AtomicInteger counter=new AtomicInteger(1001);
	int CustomerId;
	String FirstName;
	String Last_name;
	String email;
	String Password;
	double RegistrationAmount=0;
	LocalDate dob;
	Plan plan;
	
	public Customer(String FirstName,String Last_name,String email,String Password,LocalDate dob,double RegistraionAmount,Plan plann) 
	{
		this.CustomerId=counter.getAndIncrement();
		this.FirstName=FirstName;
		this.Last_name=Last_name;
		this.email=email;
		this.Password=Password;
		this.dob=dob;	
		this.plan=plann;
	}
	public boolean equals(Object o)
	{
		System.out.println("in Customer equals");
		if(o instanceof Customer)
		{
			Customer cust=(Customer)o;
		return this.email.equals(cust.email);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", FirstName=" + FirstName + ", Last_name=" + Last_name
				+ ", email=" + email + ", Password=" + Password + ", RegistrationAmount=" + RegistrationAmount
				+ ", dob=" + dob + ", plan=" + plan + "]";
	}
	
	@Override
	public int compareTo(Customer o) {
		return this.email.compareTo(o.email);
	}
	public Customer(String email)
	{
		this.email=email;
	}
	public Customer(String email,String password)
	{
		this.email=email;
		this.Password=password;
	}

	
	public String getFirstName() {
		return FirstName;
	}

	
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLast_name() {
		return Last_name;
	}

	
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	
	public String getPassword() {
		return Password;
	}

	
	public void setPassword(String password) {
		Password = password;
	}

	public double getRegistrationAmount() {
		return RegistrationAmount;
	}

	
	public void setRegistrationAmount(double registrationAmount) {
		RegistrationAmount = registrationAmount;
	}

	
	public LocalDate getDob() {
		return dob;
	}

	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Plan getP() {
		return plan;
	}

	public void setP(Plan p) {
		this.plan = plan;
	}

}
