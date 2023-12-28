package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.services.BankServices;
import com.ilp.services.CustomerServices;
import com.ilp.services.ProductService;

public class BankUtility {

	public static void main(String[] args) {
		
		ArrayList<Service> serviceList=new ArrayList<Service>();
		ArrayList<Product> productList=new ArrayList<Product>();
		Customer customer=null;
		
		Scanner scanner=new Scanner(System.in);
		char repeatChoice;
		do {
		System.out.println("**********Welcome to Bank*************");
		System.out.println("1.Create Service\n2.Create Product\n3.Create Customer\n4.Manage Accounts\n5.Display Cutomer \n6.Exit ");
		int mainChoice=scanner.nextInt();
		
			switch(mainChoice) {
			
			case 1:
//				BankServices.createServiceList(serviceList);//for testing
				BankServices.createServices(serviceList);
				System.out.println(serviceList);
				break;
			case 2:
				productList.add(ProductService.createProduct(serviceList));
				System.out.println(productList);
				break;
				
			case 3:
				customer=CustomerServices.createCustomer(customer,productList);
				System.out.println(customer);
				break;
				
			case 4:
				CustomerServices.manageAccounts(customer);
				break;
			case 5:
				CustomerServices.displayCustomerDetails(customer);
				break;
			case 6:
				System.out.println("Exiting...");
				break;
				
			}
		System.out.println("\nDo you want to go to main menu(Y/N)");
		repeatChoice=scanner.next().charAt(0);
		}while(repeatChoice=='y'||repeatChoice=='Y');
	}

}
