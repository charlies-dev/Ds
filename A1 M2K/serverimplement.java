import java.rmi.*;
import java.rmi.server.*;

public class serverimplement extends UnicastRemoteObject implements serverinterface{

   public serverimplement() throws RemoteException{
   
   }
   
   public double mtok(double m) throws RemoteException{
     
    double k;
    k = m * 1.60934;
    return k;
   }
}
