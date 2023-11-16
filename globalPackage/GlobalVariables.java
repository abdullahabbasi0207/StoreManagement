package globalPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import backEndPackage.AddNewProducts;

public class GlobalVariables {

	public Scanner scan = new Scanner(System.in);
	public AddNewProducts addNewProducts;
	public File storeProductList ; 
	public FileWriter fileWriter ;
}
