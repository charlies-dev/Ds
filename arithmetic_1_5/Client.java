package arithmetic_1_5;



import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            Registry registry = LocateRegistry.getRegistry(serverAddress, 1099);
            IArithmetic arithmetic = (IArithmetic) registry.lookup("Arithmetic");
            double a = 12.5, b = 3.0;
            System.out.println("add(" + a + ", " + b + ") = "
                    + arithmetic.add(a, b));
            System.out.println("sub(" + a + ", " + b + ") = "
                    + arithmetic.sub(a, b));
            System.out.println("mul(" + a + ", " + b + ") = "
                    + arithmetic.mul(a, b));
            System.out.println("div(" + a + ", " + b + ") = "
                    + arithmetic.div(a, b));
            System.out.println("pow(" + a + ", " + b + ") = "
                    + arithmetic.pow(a, b));

            double celsius = 25.0;
            System.out.println("celsiusToFahrenheit(" + celsius + ") = "
                    + arithmetic.celsiusToFahrenheit(celsius));

            double miles = 5.0;
            System.out.println("milesToKilometers(" + miles + ") = "
                    + arithmetic.milesToKilometers(miles));

            String msg = "Hello, RMI!";
            System.out.println("echo(\"" + msg + "\") = \""
                    + arithmetic.echo(msg) + "\"");

            String s1 = "apple", s2 = "banana";
            System.out.println("lexiconCompare(\"" + s1 + "\", \"" + s2 + "\") = \""
                    + arithmetic.lexiconCompare(s1, s2) + "\"");

            String text = "Distributed";
            System.out.println("vowelCounter(\"" + text + "\") = "
                    + arithmetic.vowelCounter(text));

            int n = 10;
            BigInteger fact = arithmetic.factorialCalculator(n);
            System.out.println("factorialCalculator(" + n + ") = "
                    + fact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
