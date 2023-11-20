package backEndPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import globalPackage.GlobalVariables;

public class UpdateTheStock {

	GlobalVariables globalVariables = new GlobalVariables();

	ArrayList<String> storeList = new ArrayList<String>();

	public void updateStock() {
		globalVariables.storeProductList = new File(
				"C:\\Users\\INTEL\\Desktop\\Abdullah\\StoreManagementFiles\\StoreProductList.txt");
		try {
			globalVariables.fileReader = new Scanner(globalVariables.storeProductList);

			// to store the data from file to collection
			while (globalVariables.fileReader.hasNextLine()) {
				storeList.add(globalVariables.fileReader.nextLine());
			}
			globalVariables.fileReader.close();
			// finding the required item
			int counter = 0;
			System.out.println("Enter the product name you want to update ? ");
			String productName = globalVariables.scan.next();
			for (String i : storeList) {
				if (i.trim().startsWith(productName)) {
					String productDetails[] = i.split("\t");
					System.out.println("1. Update the Amount \n2. Update the Qty");
					int index = globalVariables.scan.nextInt() == 1 ? 1 : 2;
					System.out.println("Enter the updated value");
					productDetails[index] = globalVariables.scan.next();

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

			globalVariables.fileWriter = new FileWriter(globalVariables.storeProductList);

			for (String k : storeList) {
				globalVariables.fileWriter.write(k + "\n");
			}
			globalVariables.fileWriter.close();
			System.err.println("Product updated successfully ! ");

		} catch (FileNotFoundException e) {
			System.err.println("File not found ! ");
		} catch (IOException e) {
			System.err.println("input / output exception");
		}
	}

}
