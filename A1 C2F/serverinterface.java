import java.rmi.*;

interface serverinterface extends Remote{

	public double ctof(double c) throws RemoteException;
}
