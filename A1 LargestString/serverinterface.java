import java.rmi.*;

interface serverinterface extends Remote{

	public String getlargeststring(String s1 , String s2) throws RemoteException;
}
