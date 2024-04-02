package com.bofa.service;

import java.util.List;

public interface CustomerService {
	
	public List<String> addCustomer(String Name);
	public List<String> deleteCustomer(String Name);
	public void listCustomer();
	public List<String> updateCustomer(String Name);
	
	
}
