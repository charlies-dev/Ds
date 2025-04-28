import StringReverserApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class Client {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the object reference in naming
            String name = "StringReverser";
            StringReverser reverser = StringReverserHelper.narrow(ncRef.resolve_str(name));

            // Use the object
            String input = "Hello CORBA";
            String output = reverser.reverse_string(input);
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + output);

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
