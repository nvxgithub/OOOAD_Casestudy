package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class CustomerServices {

	//Create Customer Function
	public static Customer createCustomer(Customer customer, ArrayList<Product> productList) {
		
		Scanner scanner=new Scanner(System.in);
	
	if(customer==null) {
			System.out.println("Create a new Customer");
			ProductService.displayProducts(productList);
			char repeatchoice;
			ArrayList<Account> addedAccoutList=new ArrayList<Account>();
			
			do {
			System.out.println("Enter the choice");
			int accChoice=scanner.nextInt();
			
			String accName=productList.get(accChoice-1).getProductName();
			String accCode="acc"+accChoice;
			
			
			System.out.println("Enter the initial balance amount");
			double accBalance=scanner.nextDouble();
			
			Account account=new Account(accCode,accName,accBalance,productList.get(accChoice-1));
			addedAccoutList.add(account);
			
			System.out.println("Do you want to add more account (y/n)");
			repeatchoice=scanner.next().charAt(0);
			}while(repeatchoice=='y');
			
			System.out.println("Enter the customer Name");
			String customerName=scanner.nextLine();
			System.out.println("Enter the customer Code");
			String customerCode=scanner.nextLine();
	
			
			customer=new Customer(customerCode,customerName,addedAccoutList);
		}
	return customer;	
	}

	
	//Manage Account Function
	public static void manageAccounts(Customer customer) {
		
	if(customer!=null){	
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the customer Code");
		String customerCode=scanner.nextLine();
		
			if(customerCode.compareToIgnoreCase(customer.getCustomerCode())==0) {
				
				ArrayList<Account> accountList=customer.getAccountList();
				
				int i=1;
				System.out.println(customer.getCustomerName()+" has the following accounts");
				for(Account account:accountList) {
					System.out.println(i+"."+account.getAccountName());
					i++;
				}
				System.out.println("Enter your choice");
				int accChoice=scanner.nextInt();
				char repeatChoice;
			if(accChoice<i) {
			do {
				System.out.println("1.Deposit\n2.Withdraw\n3.Display Balance\n");
				System.out.println("Enter your choice");
				int serviceChoice=scanner.nextInt();
				
				double amount;
				Account selectedAcc =accountList.get(accChoice-1);
				double currentBal=selectedAcc.getAccountBalance();
				
				
						switch(serviceChoice) {
						case 1:
							deposit(selectedAcc);
							break;
						case 2:
							withdraw(selectedAcc);
							break;
						case 3:
							System.out.println("Current Balance:"+selectedAcc.getAccountBalance());
						}
						
						System.out.println("Do you want to manage more (y/n)");
						repeatChoice=scanner.next().charAt(0);
					}while(repeatChoice=='y');
				}
			else {
				System.out.println("No such choice");
			}
			}
		}
	else {
		System.out.println("Customer is not created");
	}
	}



//Deposit Function
	private static void deposit(Account selectedAcc) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be deposited");
		double amount=scanner.nextDouble();
		
		if(selectedAcc.getProduct() instanceof LoanAccount) {
			System.out.println("1.Cash Deposit or 2.Cheque deposit");
			int depositChoice=scanner.nextInt();
			LoanAccount loanAccount = (LoanAccount) selectedAcc.getProduct();
			
				if(depositChoice==2) {
					double deductAmount=amount-(amount*loanAccount.getCheckDepositRate());
					selectedAcc.setAccountBalance(selectedAcc.getAccountBalance()+deductAmount);
					System.out.println("Balance:"+selectedAcc.getAccountBalance());
				}
				else {
					selectedAcc.setAccountBalance(selectedAcc.getAccountBalance()+amount);
					System.out.println("Balance:"+selectedAcc.getAccountBalance());
				}
		}
		else {
			selectedAcc.setAccountBalance(selectedAcc.getAccountBalance()+amount);
			System.out.println("Balance:"+selectedAcc.getAccountBalance());
		}
		
	}
	
//Withdraw Function
	
	private static void withdraw(Account selectedAcc) {
	
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be withdrawn");
		double amount=scanner.nextDouble();
		
		if(selectedAcc.getProduct() instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedAcc.getProduct();
			if((selectedAcc.getAccountBalance()-amount)<savingsMaxAccount.getMinBalance()) {
				System.out.println("Insufficient balance");
			}
			else {
				selectedAcc.setAccountBalance(selectedAcc.getAccountBalance()-amount);
				System.out.println("Balance:"+selectedAcc.getAccountBalance());
			}
		}
		else if(selectedAcc.getProduct() instanceof LoanAccount){
			System.out.println("Cannot withdraw from LoanAccount");
		}
		else {
			selectedAcc.setAccountBalance(selectedAcc.getAccountBalance()-amount);
			System.out.println("Balance:"+selectedAcc.getAccountBalance());
		}
		
	}


	public static void displayCustomerDetails(Customer customer) {
		
		if(customer!=null) {
		System.out.println("****************Customer-Account Details***************");
		System.out.println("CustomerId \tCustomerName \tAccountType \t\tBalance");
		System.out.println("*******************************************************");
		
		ArrayList<Account> accountList =customer.getAccountList();
		
		for(Account account:accountList) {
			System.out.print("\n"+customer.getCustomerCode());
			System.out.print("\t\t"+customer.getCustomerName());
			System.out.print("\t\t"+account.getAccountName());
			System.out.print("\t\t"+account.getAccountBalance());
			
			System.out.println("\nServices Provided:");
			for(Service service:account.getProduct().getServiceList()) {
					System.out.print(service.getServiceName());
					System.out.print(", ");
				}
			}
		}
	}
	
	
	
	
}
