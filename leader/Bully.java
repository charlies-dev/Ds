
import java.util.Scanner;

public class Bully {

    static int pid[];
    static int status[];
    static int cordinator;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of processes");

        n = sc.nextInt();

        pid = new int[n];
        status = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter PID & status (1 - Active , 0 - Inactive) of process" + i);
            pid[i] = sc.nextInt();
            status[i] = sc.nextInt();
        }

        System.out.println("Index   PID    Status");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "    " + pid[i] + "   " + status[i]);
        }

        int ele;

        while (true) {
            System.out.println("Enter Process index initiating Election: ");
            ele = sc.nextInt();
            if (ele < 0 || ele >= n)
                System.out.println("Current proceess is out of bound  TRY AGAIN");
            if (status[ele] == 0) {
                System.out.println("Current procees if Inactive TRY AGAIN!");
            } else {
                break;
            }
        }
        runElection(ele);

        System.out.println("After Election process Final Cordinator is: " + pid[cordinator]);
        sc.close();

    }

    public static void runElection(int ele) {
        cordinator = ele;
        System.out.println("");
        for (int i = 0; i < n; i++) {
            if (pid[i] > pid[ele]) {
                System.out.println("ELECTION msg sent from  " + (ele) + "to " + (i));
                if (status[i] == 1) {
                    runElection(i);
                }
            }
        }
    }

}
