package backEndPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import globalPackage.GlobalVariables;

public class Bill {
	GlobalVariables globalVariables = new GlobalVariables();
	ArrayList<String> storeList = new ArrayList<String>();
	ArrayList<Integer> billTotal = new ArrayList<Integer>();

//	ArrayList<String> newBill = new ArrayList<String>();
	public void createBill() {
		try {
			globalVariables.fileWriter = new FileWriter(
					"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\CustomerBills\\CustomerBills.txt",
					true);

			// Customer Details
			System.err.println("Please enter Customer's following details ");
			System.out.println("Date : ");
			globalVariables.fileWriter
					.write("\n" + "\t* * * * Bill * * * *\n" + "Date : " + globalVariables.scan.next());
			System.out.println("Name : ");
			globalVariables.fileWriter.write("\nName : " + globalVariables.scan.next());
			System.out.println("Contact : ");
			globalVariables.fileWriter.write("\nContact : " + globalVariables.scan.nextInt());
			System.out.println("Address : ");
			globalVariables.fileWriter.write("\nAddress : " + globalVariables.scan.next());
			globalVariables.fileWriter.write("\nBill Details");
			// Buying Details
			int transactions = 1;
			do {
				System.out.println("Please enter the following product details");
				System.out.println("Product Name : ");
				String productName = globalVariables.scan.next();

				System.out.println("Qty. bought : ");
				int qty = globalVariables.scan.nextInt();
				globalVariables.storeProductList = new File(
						"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\StoreProductList.txt");

				globalVariables.fileReader = new Scanner(globalVariables.storeProductList);

				// to store the data from file to collection
				if (transactions == 1) {
					while (globalVariables.fileReader.hasNextLine()) {
//						System.out.println(globalVariables.fileReader.nextLine());
						storeList.add(globalVariables.fileReader.nextLine());
					}
				}

				globalVariables.fileReader.close();
				System.out.println(productName + storeList);
				// get the amount
				int counter = 0;
				for (String i : storeList) {
					System.out.println("****** djf **** " + counter);
					if (i.trim().startsWith(productName)) {
						String productDetails[] = i.split("\t");
						int amount = Integer.parseInt(productDetails[1]);
						int productTotal = qty * amount;
						globalVariables.fileWriter
								.write("\n\n" + qty + " " + productName + " X " + amount + " = " + productTotal + "/-");
						billTotal.add(productTotal);

						// updating the stock after purchased
						// updateing the array
						productDetails[2] = (Integer.parseInt(productDetails[2]) - qty) + "";

						// creating updated string to store in collections
						String updatedString = "";
						for (String j : productDetails) {
							updatedString = updatedString + j + "\t";
						}
						storeList.remove(counter);
						storeList.add(counter, updatedString.trim());
						break;
					}
					counter++;
				}

//				//updateing the stock
//				updateTheDatabase();

				System.err.println("To add more products.... Press 1");
				transactions++;
			} while (globalVariables.scan.nextInt() == 1);

			// updateing the stock
			updateTheDatabase();

			int total = 0;
			for (Integer j : billTotal) {
				total = total + j;
			}
//			globalVariables.fileWriter = new FileWriter(
//					"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\CustomerBills\\CustomerBills.txt",
//					true);
			globalVariables.fileWriter
					.write("\n\nGrand Total : $" + total + "/-\n-------------------------------------");
			globalVariables.fileWriter.close();

		} catch (IOException e) {

		}

	}

	public void updateTheDatabase() {
		try {
			System.out.println(" U U U U U ");
			globalVariables.fileWriter1 = new FileWriter(
					"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\StoreProductList.txt");
			for (String k : storeList) {
				globalVariables.fileWriter1.write(k + "\n");
			}
			globalVariables.fileWriter1.close();
		} catch (IOException e) {
			System.err.println(" ");
		}
	}

	public void viewBill() {
		ArrayList<String> bills = new ArrayList<String>();
		globalVariables.storeProductList = new File(
				"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\CustomerBills\\CustomerBills.txt");
		try {
			globalVariables.fileReader = new Scanner(globalVariables.storeProductList);

			System.out.println("Customer number : ");
			int uniqueKey = globalVariables.scan.nextInt();

			while (globalVariables.fileReader.hasNextLine()) {
				String date = globalVariables.fileReader.nextLine();
				if (date.startsWith("Date : ")) {
					String name = globalVariables.fileReader.nextLine();
					if (globalVariables.fileReader.nextLine().equals("Contact : " + uniqueKey)) {

						// holding up all the transactions
						String newLine = "";
						String transactions = "";
						while (globalVariables.fileReader.hasNextLine()
								&& (!(newLine = globalVariables.fileReader.nextLine()).startsWith("-"))) {
							transactions = transactions + newLine + "\t";
//							System.out.println(transactions);
						}
						bills.add(date + "\t" + name + "\t" + "Contact : " + uniqueKey + "\t" + transactions);
					
					}
				}

			}

			//getting all bills using a particular contact details
			for(String i : bills) {
				System.out.println(i);
			}
			System.out.println("Enter the date ");
			String date = globalVariables.scan.next();
			
			//showing bill
			for(String j : bills) {
				if(j.startsWith("Date : " + date)) {
					System.out.println(j);
				}
			}
			
		} catch (FileNotFoundException e) {

		}

	}
}
