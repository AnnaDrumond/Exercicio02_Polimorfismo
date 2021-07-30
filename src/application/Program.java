package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int quantitity = scanner.nextInt();

		for (int i = 1; i <= quantitity; i++) {
			System.out.println("Product #" + i + " data: ");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = scanner.next().charAt(0);
			scanner.nextLine();
			
			System.out.print("Name: ");
			String name = scanner.nextLine();
			
			System.out.print("Price: ");
			double price = scanner.nextDouble();
			
			// Testando se o produto é usado, comum ou importado:
			
			if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(scanner.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			
			} else if (type == 'i'){
				System.out.print("Customs fee: ");
				double customsFee = scanner.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			
			} else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		// For each para percorrer e imprimir a lista de produtos, de acordo com o tipo e características de cada um:
		
		for ( Product product : list) {
			System.out.println(product.priceTag());
		}
		scanner.close();
	}
}
