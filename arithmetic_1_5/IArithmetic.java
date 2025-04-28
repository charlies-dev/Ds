package arithmetic_1_5;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IArithmetic extends Remote {
    public double add(double num1, double num2) throws RemoteException;

    public double sub(double num1, double num2) throws RemoteException;

    public double mul(double num1, double num2) throws RemoteException;

    public double div(double num1, double num2) throws RemoteException;

    public double pow(double num1, double num2) throws RemoteException;

    public double celsiusToFahrenheit(double num1) throws RemoteException;

    public double milesToKilometers(double num1) throws RemoteException;

    public String echo(String msg) throws RemoteException;

    public String lexiconCompare(String str1, String str2) throws RemoteException;

    public int vowelCounter(String str1) throws RemoteException;

    public BigInteger factorialCalculator(int num) throws RemoteException;

}