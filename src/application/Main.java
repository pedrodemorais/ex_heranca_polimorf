package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String name;
		Double price;
		Double customFee;
		Product prod;
		//Product prod2;
		//Product prod3;
		List<Product> list = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int numberOdProducts = input.nextInt();
		
		for(int i=0; i<numberOdProducts;i++) {
			input.nextLine();
			System.out.println("Product # "+(i+1)+" data:");
			System.out.print("Common, used or impoted (c/u/i)? ");
			char typeProduct = input.next().charAt(0);
			
			switch  (typeProduct) {
				case 'c':
					input.nextLine();
					System.out.print("Name:");
					name = input.nextLine();
					System.out.print("Price:");
					price = input.nextDouble();
					
					prod = new Product(name, price);
					list.add(prod);
					break;
				case 'u':
					input.nextLine();
					System.out.print("Name:");
					name = input.nextLine();
					System.out.print("Price:");
					price = input.nextDouble();
					input.nextLine();
					System.out.println("Manufacture date (DD/MM/YYYY)");
					Date dateManufacture = sdf.parse(input.nextLine());
					prod = new UsedProduct(name, price, dateManufacture);
					list.add(prod);
					break;
				case 'i':
					input.nextLine();
					System.out.print("Name:");
					name = input.nextLine();
					System.out.print("Price:");
					price = input.nextDouble();
					System.out.print("Customs fee:");
					customFee = input.nextDouble();
					prod = new ImportedProduct(name, price, customFee);
					list.add(prod);
					
					break;
			
			}
			
		}
		
		System.out.println("\nPRICE TAGS:");
		for(Product x: list) {
			System.out.print(x.priceTag());
			
		}
		input.close();

	}

}
