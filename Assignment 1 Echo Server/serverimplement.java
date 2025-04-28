import java.rmi.*;
import java.rmi.server.*;

public class serverimplement extends UnicastRemoteObject implements serverinterface{

   public serverimplement() throws RemoteException{
   
   }
   
   public String echoserver(String s1) throws RemoteException{
    
    return "Hello " + s1;
   }                                                                                    
}
