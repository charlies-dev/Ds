import java.rmi.*;
import java.rmi.server.*;

public class serverimplement extends UnicastRemoteObject implements serverinterface{

   public serverimplement() throws RemoteException{
   
   }
   
   public String getlargeststring(String s1, String s2) throws RemoteException{
     
    String result;
    result = (s1.compareTo(s2) >= 0 )?s1:s2;
    return result;
   }                                                                                    
}
