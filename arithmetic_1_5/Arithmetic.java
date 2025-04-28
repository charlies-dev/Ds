package arithmetic_1_5;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Arithmetic extends UnicastRemoteObject implements IArithmetic {

    public Arithmetic() throws RemoteException {
        // document why this constructor is empty
    }

    @Override
    public double add(double num1, double num2) throws RemoteException {

        return num1 + num2;
    }

    @Override
    public double sub(double num1, double num2) throws RemoteException {

        return num1 - num2;
    }

    @Override
    public double mul(double num1, double num2) throws RemoteException {

        return num1 * num2;
    }

    @Override
    public double div(double num1, double num2) throws RemoteException {

        if (num2 == 0) {
            throw new ArithmeticException("Zero Divide error");
        }
        return num1 / num2;
    }

    @Override
    public double pow(double num1, double num2) throws RemoteException {

        return Math.pow(num1, num2);
    }

    @Override
    public double celsiusToFahrenheit(double num1) throws RemoteException {

        return (num1 * 9.0 / 5.0) + 32.0;
    }

    @Override
    public double milesToKilometers(double num1) throws RemoteException {

        return num1 * 1.60934;
    }

    @Override
    public String echo(String msg) throws RemoteException {

        return "Hello" + msg;
    }

    @Override
    public String lexiconCompare(String str1, String str2) throws RemoteException {

        if (str1.compareTo(str2) >= 0) {
            return str1;
        }
        return str2;
    }

    @Override
    public int vowelCounter(String str1) throws RemoteException {

        int count = 0;

        for (char item : str1.toCharArray()) {
            if (item == 'a' || item == 'e' || item == 'i' || item == 'o' || item == 'u') {
                count++;
            }
        }

        return count;
    }

    @Override
    public BigInteger factorialCalculator(int num) throws RemoteException {

        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(num).multiply(factorialCalculator(num - 1));

    }

}
