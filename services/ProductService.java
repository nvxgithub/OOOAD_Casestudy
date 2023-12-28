package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductService {

public static Product createProduct(ArrayList<Service> serviceList) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Product Code:-");
		String productCode=scanner.nextLine();
		System.out.println("Product Name(SavingsMaxAccount,LoanAccount,CurrentAccount):-");
		String productName=scanner.nextLine();
		ArrayList<Service> addedServiceList=new ArrayList<Service>();
		System.out.println("These are the services");
		BankServices.displayServices(serviceList);
		
		char repeatChoice;
		do {
			System.out.println("enter the service code to add ");
			String serviceCode=scanner.next();
			
			for(Service service:serviceList) {
				if(service.getServiceCode().compareToIgnoreCase(serviceCode)== 0)
				{
					addedServiceList.add(service);
					break;
				}
			}
			
			System.out.println("Add more services?(y/n)");
		repeatChoice=scanner.next().charAt(0);
		}while(repeatChoice=='y');
		
		Product product=null;
		
		if(productName.compareToIgnoreCase("SavingsMaxAccount")==0) {
			product =new SavingsMaxAccount(productCode,productName,addedServiceList,1000);
		}
		else if(productName.compareToIgnoreCase("LoanAccount")==0) {
			product =new LoanAccount(productCode,productName,addedServiceList,0.3);
		}
		else if(productName.compareToIgnoreCase("CurrentAccount")==0) {
			product =new CurrentAccount(productCode,productName,addedServiceList);
		}
		else {
			System.out.println("Invalid");
		}
		
		
		return product;
	}

	public static void displayProducts(ArrayList<Product> productList) {
		
		System.out.println("*****Accounts available******");
		int i=1;
		for(Product product:productList) {
			System.out.println(i+"."+product.getProductName());
			i++;
		}
		
	}
	
}
