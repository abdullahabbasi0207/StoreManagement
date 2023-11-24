package frontEndPackage;

import java.util.Scanner;

import backEndPackage.AddNewProducts;
import backEndPackage.Bill;
import backEndPackage.UpdateTheStock;
import globalPackage.GlobalVariables;

public class MainScreen {
	GlobalVariables globalVariables = new GlobalVariables();

	void mainScreen() {
		do {
			System.err.println("\n\t\t * * * * * * Main Screen * * * * * *  \n " + "\n1. ADD NEW PRODUCTS\n"
					+ "\n2. UPDATE THE STOCK\n" + "\n3. BILL\n" + "\n4. LIST OF PRODUCTS AVAILABLE IN STORE\n"
					+ "\n5. EXIT\n");
			int check = globalVariables.scan.nextInt();
			switch (check) {
			case 1:
				globalVariables.addNewProducts = new AddNewProducts();
				globalVariables.addNewProducts.addNewProductFunction();
				break;
			case 2:
				globalVariables.updateTheStock = new UpdateTheStock();
				globalVariables.updateTheStock.updateStock();
				break;
			case 3:
				System.out.println("1. Make Bill \n2. Search Bill ");
				globalVariables.bill = new Bill();
//				globalVariables.scan.nextInt() == 1 ? globalVariables.bill.createBill() : globalVariables.bill.viewBill();
				if(globalVariables.scan.nextInt() == 1) {
					globalVariables.bill.createBill();
				}else {
					globalVariables.bill.viewBill();
				}
				break;
			case 4:
				break;
			case 5:
				System.exit(0);
				break;

			}
		} while (true);
	}

	public static void main(String[] args) {
		MainScreen mainScreen1 = new MainScreen();

		mainScreen1.mainScreen();

	}
}
