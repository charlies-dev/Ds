import java.rmi.*;

interface serverinterface extends Remote{

	public double mtok(double m) throws RemoteException;
}
