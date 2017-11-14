import java.io.File;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {


		Reader leser= new Reader(new File("input.xml"));

		
		Scanner sc=new Scanner(System.in);
		String input= sc.next();
		
		sc.close();
		
		
		System.out.println(leser.getPrice(input));
		


		
	}

}
