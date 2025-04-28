import java.util.*;

public class TokenRing{
	public static void main(String[] args)
	{
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Enter number of nodes u want in taken ring: ");
	  int n = sc.nextInt();
	  
	  System.out.println("Ring Formation: ");
	  for(int i=0; i<n; i++)
	  {
	  System.out.print(i + "---");
	  }
	  System.out.println("0");
	  
	  int sender, receiver, data;
	  int choice;
	  
	  do{
	    System.out.println("Enter a Sender : ");
	    sender = sc.nextInt();
	    
	    System.out.println("Enter a Receiver : ");
	    receiver = sc.nextInt();
	    
	    System.out.println("Enter a data to be send : ");
	    data = sc.nextInt();
	    
	    int token = 0;
	    System.out.println("Token Passing: ");
	    for(int i=token; i<sender; i++)
	    {
	    System.out.print(i + "->");
	    }
	    System.out.println(" " + sender);
  System.out.println("Sender: " + sender + " Sending the data : " + data);
  
     for(int i=sender; i !=receiver; i = (i+1)%n)
     {
     System.out.println("Data: " + data + " Forwarded by " + i);
     }
     
     System.out.println("Receiver: " + receiver + " Received the data : " + data);
     
     token = sender;
      System.out.println("Do you want to continue : Y=1 OR N=0");
      choice = sc.nextInt();
	  }while(choice == 1);
	  sc.close();
	}
}
