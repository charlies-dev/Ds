import java.rmi.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try{
		 String url = "rmi://localhost/Server";
		 serverinterface sif = (serverinterface) Naming.lookup(url);
		 System.out.println("Enter String 1: ");
		 String s1 = sc.nextLine();
		 System.out.println("Enter String 2: ");
		 String s2 = sc.nextLine();
		 System.out.println("Largest String : " + sif.getlargeststring(s1,s2));
		}
		catch(Exception e){
		 System.out.println(" Exception : " + e.getMessage());
		}
		sc.close();
	}
}
