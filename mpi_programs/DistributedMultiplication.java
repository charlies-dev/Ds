
import mpi.MPI;


public class DistributedMultiplication {
    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] data = new int[size]; 
        int[] recvBuf = new int[1]; 

        if (rank ==0) {
            data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = (i + 1);
            }
            System.out.print("Root initialized array: ");
            for (int num : data) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        MPI.COMM_WORLD.Scatter(data, 0, 1, MPI.INT, recvBuf, 0, 1, MPI.INT, 0);

        int receivedNumber = recvBuf[0];
        int intermediateMultiplication = receivedNumber * 5;
        System.out.println("Process " + rank + " received " + receivedNumber +
                           " and calculated intermediate multiplication: " + intermediateMultiplication);

        MPI.Finalize();
    }
}
