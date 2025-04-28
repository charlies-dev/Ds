import java.rmi.*;

interface serverinterface extends Remote{

	public int vowelCount(String s1) throws RemoteException;
}
