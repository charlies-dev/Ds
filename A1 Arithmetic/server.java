import java.rmi.*;

public class server{
	public static void main(String[] args)
	{
	   try{
	   serverimp sip = new serverimp();
	   Naming.rebind("Server", sip);
	   System.out.println("Server Started...!");
	   }
	   catch(Exception e)
	   {
	   System.out.println("Server Exception" + e.getMessage());
	   }
	}
}
