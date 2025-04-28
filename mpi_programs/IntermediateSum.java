import mpi.*;

public class IntermediateSum {
    public static void main(String[] args) throws Exception {
        MPI.Init(args); // Initialize MPI Environment
        int rank = MPI.COMM_WORLD.Rank(); // Process ID
        int size = MPI.COMM_WORLD.Size(); // Total Processes

        int[] data = new int[size];
        int[] recvBuf = new int[1];

        if(rank == 0) {
            // Root process initializes array
            for(int i = 0; i < size; i++) {
                data[i] = i + 1; // Example: [1,2,3,4,...]
            }
        }

        // Scatter one element to each process
        MPI.COMM_WORLD.Scatter(data, 0, 1, MPI.INT, recvBuf, 0, 1, MPI.INT, 0);


        // Each process computes intermediate sum
        int intermediateSum = recvBuf[0] * 2; // Example operation

        System.out.println("Processor " + rank + " received " + recvBuf[0] + " and calculated intermediate sum: " + intermediateSum);

        MPI.Finalize(); // Finalize MPI Environment
    }
}
