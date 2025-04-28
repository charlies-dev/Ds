package arithmetic_1_5;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Arithmetic arithmetic = new Arithmetic();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Arithmetic", arithmetic);
            System.out.println("Server is Running");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
