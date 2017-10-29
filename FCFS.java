package ie.gmit.sw;
import java.util.*;
class FCFS
{
    public static void main(String[] args)
    {
    	int i=0;
    	int n;
    	int id[]=new int[20];
        int btime[]=new int[20];
        int wtime[]=new int[20];
        int total=0;
        float avg;
        Scanner sn = new Scanner(System.in);
       
        System.out.println("Enter the number of processes : ");
        System.out.println("i is"+i);
        
        n=3;//sn.nextInt();
        System.out.println("i is"+i);
        for (i=0; i<n;i++)
		{
            System.out.println("i is"+i);
            
			System.out.print("Enter the process name for the process "+(i+1)+" : ");
            id[i]=sn.nextInt();
            System.out.print("Enter the burst time of process "+(i+1)+" : ");
            btime[i]=sn.nextInt();
        }
        wtime[0]=0;
        for (i=1;i<n;i++)      {
            wtime[i]=wtime[i-1]+btime[i-1];
            total=total+wtime[i];
        }
        avg=(float)total/n;
        System.out.println("\nProcess_ID\tBurst_time\tWait_time");
        
        for(i=0;i<n;i++)
        {
            System.out.println(id[i]+"\t\t"+btime[i]+"\t\t"+wtime[i]);
        }
        System.out.println("\nTotal wait time: "+total+"\nAverage wait time: "+avg);
    }
 
}
