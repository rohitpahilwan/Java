package com.sortcustomerlist;

import java.util.Comparator;

import com.customerclass.Customer;

public class SortList implements Comparator<Customer> {
	@Override
	public int compare(Customer o1,Customer o2)
	{
		int ret=o1.getDob().compareTo(o2.getDob());
		if(ret==0)
		{
			return o1.getLast_name().compareTo(o2.getLast_name());
		}
		return ret;
	}

}
