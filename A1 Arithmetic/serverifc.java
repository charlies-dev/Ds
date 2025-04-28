import java.rmi.*;

interface serverifc extends Remote{
     
     public int add(int a, int b) throws RemoteException;
     public int sub(int a, int b) throws RemoteException;
     public int mul(int a, int b) throws RemoteException;
     public int div(int a, int b) throws RemoteException;
     public long powercalculations(int a) throws RemoteException;
     public int factorial(int a) throws RemoteException;
}
