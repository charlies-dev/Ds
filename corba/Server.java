import StringReverserApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;

public class Server {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant and register it with ORB
            StringReverserImpl reverserImpl = new StringReverserImpl();

            // Get object reference from servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(reverserImpl);
            StringReverser href = StringReverserHelper.narrow(ref);

            // Get naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the object reference in naming
            String name = "StringReverser";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("String Reverser Server ready and waiting...");

            // Wait for client invocation
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
