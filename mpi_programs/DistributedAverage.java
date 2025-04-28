
import java.util.Random;
import mpi.MPI;

public class DistributedAverage {

    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        final int TOTAL_NUMBERS = 16;
        int numberPerProcess = TOTAL_NUMBERS / size;

        int[] sendBuf = new int[TOTAL_NUMBERS];
        int[] recvBuf = new int[numberPerProcess];

        if (rank == 0) {
            sendBuf = new int[TOTAL_NUMBERS];
            Random ran = new Random();
            System.err.println("Root generated Numbers : ");

            for (int i = 0; i < TOTAL_NUMBERS; i++) {
                sendBuf[i] = ran.nextInt(100);
                System.out.print(sendBuf[i] + " ");
            }
            System.out.println();
        }

        MPI.COMM_WORLD.Scatter(sendBuf, 0, numberPerProcess, MPI.INT, recvBuf, 0, numberPerProcess, MPI.INT, 0);

        int localSum = 0;
        for (int i : recvBuf) {
            localSum += i;
        }
        double localAvg = (double) localSum / numberPerProcess;
        System.out.println("Process " + rank + " calculated local average: " + localAvg);
        double[] localAvgBuf = new double[]{localAvg};
        double[] gatheredAvgs = new double[size];
        if (rank == 0) {
            gatheredAvgs = new double[size];
        }

        MPI.COMM_WORLD.Gather(localAvgBuf, 0, 1, MPI.DOUBLE, gatheredAvgs, 0, 1, MPI.DOUBLE, 0);

        if (rank == 0) {
            double finalSum = 0.0;
            for (double avg : gatheredAvgs) {
                finalSum += avg;
            }
            double finalAverage = finalSum / size;
            System.out.println("Final average calculated at root: " + finalAverage);
        }
        MPI.Finalize();
    }
}
