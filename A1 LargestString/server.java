import java.rmi.*;

public class server{
	public static void main(String[] args)
	{
	  try{
	  
	  serverimplement sip = new serverimplement();
	  Naming.rebind("Server", sip);
	  System.out.println("Server is running");
	  }
	  catch(Exception e){
	  System.out.println("Server Exception : " + e.getMessage());
	  }
	}
}
