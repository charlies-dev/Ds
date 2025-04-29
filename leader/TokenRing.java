import java.util.Arrays;
public class TokenRing {

    public static void main(String[] args) {
        

        int n = 5;

        int pid[] = new int[] {12 ,34 ,33 , 54 ,32};
        int failedProcess = 0;

        int leader = 0;

        int starter = 1;
        int token[] = new int[n];
        token[0] = pid[starter];

        for(int i = starter + 1 ; i !=  starter ;){

            if( i != failedProcess){
                token[i] = pid[i];
                System.out.println("Process " + pid[i] + "Updates Token" + Arrays.toString(token));
            }


            i=(i+ 1)%n;
        }


        leader = Arrays.stream(token).max().getAsInt();

        System.out.println("New elected leader: "+ leader);


    }
    
}
