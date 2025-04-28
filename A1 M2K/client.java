import java.rmi.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try{
		 String url = "rmi://localhost/Server";
		 serverinterface sif = (serverinterface) Naming.lookup(url);
		 System.out.println("Enter the Distance in Miles: ");
		 double m = sc.nextDouble();
		 System.out.println("Kilometers : " + sif.mtok(m));
		}
		catch(Exception e){
		 System.out.println(" Exception : " + e.getMessage());
		}
		sc.close();
	}
}
