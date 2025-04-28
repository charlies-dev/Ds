import java.rmi.*;

interface serverinterface extends Remote{

	public String echoserver(String s1) throws RemoteException;
}
