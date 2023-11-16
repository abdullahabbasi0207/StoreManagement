package backEndPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import globalPackage.GlobalVariables;

public class AddNewProducts {
	GlobalVariables globalVariables = new GlobalVariables();
	
	public void addNewProductFunction() {
		try {
			globalVariables.storeProductList = new File("C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\StoreProductList.txt");
			globalVariables.fileWriter = new FileWriter(globalVariables.storeProductList, true);
			
			System.out.println("Name : ");
			globalVariables.fileWriter.append("\n" + globalVariables.scan.next() + "\t");
			System.out.println("Amount/piece : ");
			globalVariables.fileWriter.append(globalVariables.scan.nextInt() + "\t");
			System.out.println("Qty: ");
			globalVariables.fileWriter.append(globalVariables.scan.nextInt() + "\t");
			globalVariables.fileWriter.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found ! ");
		} catch (IOException e) {
			System.err.println("I/o Exception ! ");
		}			
	}
	
}
