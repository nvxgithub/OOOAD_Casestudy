package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class BankServices {

	public static void createServices(ArrayList<Service> serviceList) {
		char repeatChoice;
		Scanner scanner=new Scanner(System.in);
		do {
		System.out.println("Service Code:-");
		String serviceCode=scanner.nextLine();
		System.out.println("Service Name:-");
		String serviceName=scanner.nextLine();
		System.out.println("Rate:-");
		double rate=scanner.nextDouble();
		
		Service service=new Service(serviceCode,serviceName,rate);
		serviceList.add(service);
		
		System.out.println("Do you want to add more services(y/n)");
		repeatChoice=scanner.next().charAt(0);
		}while(repeatChoice=='y');
		
	}

	public static void displayServices(ArrayList<Service> serviceList) {
	
		System.out.println("Service Code\tService Name\tRate");
		for(Service service:serviceList) {
			System.out.println(service.getServiceCode()+"\t\t"+service.getServiceName()+"\t"+service.getRate());
		}
		
	}

	
	//for testing*********************************************** 
	public static void createServiceList(ArrayList<Service> serviceList) {
		
		Service service1=new Service("s1","CashDeposit",0.2);
		serviceList.add(service1);
		Service service2=new Service("s2","ChequeDeposit",0.3);
		serviceList.add(service2);
		Service service3=new Service("s3","MobileBanking",0.4);
		serviceList.add(service3);
		Service service4=new Service("s4","OnlineBanking",0.4);
		serviceList.add(service4);
		Service service5=new Service("s5","ATMWithdrawal",0.4);
		serviceList.add(service5);
		
	}

	
}
