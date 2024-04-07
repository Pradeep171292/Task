package com.bofa.service;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
	static List<String> customer = new ArrayList<>();
	
	@Override
	public List<String> addCustomer(String Name) {
		System.out.println("-----------Adding customer ------------------");
		// TODO Auto-generated method stub
		customer.add("pradeep");
		customer.add("gediya");
		customer.add("rahul");
		return customer;
	}

	@Override
	public List<String> deleteCustomer(String Name) {
		System.out.println("----------Delete Customer--------");
		customer.remove("gediya");
		return customer;
	}

	@Override
	public void listCustomer() {
		System.out.println("--------------List Customer--------------");
		customer.forEach(System.out::println);
	}

	@Override
	public List<String> updateCustomer(String Name) {
		// TODO Auto-generated method stub
		System.out.println("----------update customer--------");
		customer.add(1, "Updatevalue");
		return customer;
	}

}
