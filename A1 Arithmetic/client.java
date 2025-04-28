import java.rmi.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args)
	{
	   Scanner sc = new Scanner(System.in);
	   try{
	   
	   String url = "rmi://localhost/Server";
	   serverifc sfc = (serverifc)Naming.lookup(url);
	   System.out.println("Enter No. 1 : ");
	   int a = sc.nextInt();
	   System.out.println("Enter No. 2 : ");
	   int b = sc.nextInt();
	   System.out.println("Addition : " + sfc.add(a,b));	   
	   System.out.println("Substraction : " + sfc.sub(a,b));
	   System.out.println("Multiplication: " + sfc.mul(a,b));
	   System.out.println("Division : " + sfc.div(a,b));
	   System.out.println("Power Calculation : " + sfc.powercalculations(a));
	   System.out.println("Factorial of No. : " + sfc.factorial(a));
	   }
	   catch(Exception e)
	   {
	   System.out.println("Server Exception: " + e.getMessage());
	   }
	}
}
