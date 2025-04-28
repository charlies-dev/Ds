import java.rmi.*;
import java.rmi.server.*;

public class serverimp extends UnicastRemoteObject implements serverifc{

	public serverimp() throws RemoteException{}
	
	//addition
	public int add(int a, int b) throws RemoteException{
		return a+b;
	}
	
	//substraction
     	public int sub(int a, int b) throws RemoteException{
     		return a-b;
     	}
     	
     	
     	//multiplication
     	public int mul(int a, int b) throws RemoteException{
     		return a*b;
     	}
     	
     	//division
     	public int div(int a, int b) throws RemoteException{
     	        if(b==0) throw new ArithmeticException("Cannot Divide by zero.");
     	        return a/b;
     	}
     	
     	//powercalculations
     	public long powercalculations(int a) throws RemoteException{
     	      long result = (long)Math.pow(2,a);
     		return result;
     	}
     	
     	//factorialnumber
     	public int factorial(int a) throws RemoteException{
     	     /*int result = 1;
     	     for(int i=1; i<=a; i++)
     	     {
     	        result *= i;
     	     }
     	     return result;*/
     	     
     	     if(a==0)
     	        return 1;
     	      return a * factorial(a-1);   
     	}    	
}
