import java.rmi.*;
import java.rmi.server.*;

public class serverimplement extends UnicastRemoteObject implements serverinterface{

   public serverimplement() throws RemoteException{
   
   }
   
   public double ctof(double c) throws RemoteException{
     
    double f;
    f = (c * 9 / 5) + 32;
    return f;
   }
}
