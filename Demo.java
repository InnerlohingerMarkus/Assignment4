import java.io.File;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {


		Reader leser= new Reader(new File("input.xml"));

		
		Scanner sc=new Scanner(System.in);
		String input= sc.next();
		
		//checks for right input
		while(!input.startsWith("L") && !input.startsWith("B") && !input.startsWith("C")){
			System.out.println("Wrong input! Try again!");
			input=sc.next();
		}
		sc.close();
		
		
		
		double price=leser.getPrice(input);
		
		//checks if item exists
		if(price!=0.0)
			System.out.println(price);
		else
			System.out.println("Item not found!");
		


		
	}

}
