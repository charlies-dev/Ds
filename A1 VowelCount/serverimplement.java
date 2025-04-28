import java.rmi.*;
import java.rmi.server.*;

public class serverimplement extends UnicastRemoteObject implements serverinterface{

   public serverimplement() throws RemoteException{
   
   }
   
   public int vowelCount(String s1) throws RemoteException{
    int count = 0;
    for(char c : s1.toLowerCase().toCharArray())
    {
    	if("aeiou".indexOf(c) != -1)
    	{
    	   count++;
    	}
    }
    return count;
   }                                                                                    
}.
