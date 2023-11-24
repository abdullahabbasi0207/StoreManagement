package globalPackage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import backEndPackage.AddNewProducts;
import backEndPackage.Bill;
import backEndPackage.UpdateTheStock;

public class GlobalVariables {

	public Scanner scan = new Scanner(System.in);
	public AddNewProducts addNewProducts;
	public File storeProductList ; 
	public FileWriter fileWriter ;
	public Scanner fileReader;
	public UpdateTheStock updateTheStock;
	public Bill bill;
	public FileWriter fileWriter1 ;
}
