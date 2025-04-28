import java.rmi.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try{
		 String url = "rmi://localhost/Server";
		 serverinterface sif = (serverinterface) Naming.lookup(url);
		 System.out.println("Enter the temperature in Celcius: ");
		 double c = sc.nextDouble();
		 System.out.println("Fahrenheit : " + sif.ctof(c));
		}
		catch(Exception e){
		 System.out.println(" Exception : " + e.getMessage());
		}
		sc.close();
	}
}
