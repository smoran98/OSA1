package ie.gmit.sw;
 
import java.io.IOException;
import java.util.Scanner;
class RoundRobin
{
    public static void main(String args[])throws IOException
    {
        Scanner sn = new Scanner(System.in);   
        int i=0, j, k, q, sum=0;
        int n = sn.nextInt();
        int btime[]=new int[n];
        int wtime[]=new int[n];
        int total[]=new int[n];
        int avg[]=new int[n];
        
        System.out.println("Enter number of process:");
        System.out.println("Enter brust Time:");
        for(i=0;i<n;i++)
        {
            System.out.println("Enter brust Time for "+(i+1));
            btime[i]=sn.nextInt();
        }
        System.out.println("Enter Time quantum:");
        q = sn.nextInt();
        for(i=0;i<n;i++)
        	avg[i]=btime[i];
        for(i=0;i<n;i++)
            wtime[i]=0;
        do
        {
            for(i=0;i<n;i++)
            {
                if(btime[i]>q)
                {
                	btime[i]-=q;
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(btime[j]!=0))
                            wtime[j]+=q;
                    }
                }
                else
                {
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(btime[j]!=0))
                            wtime[j]+=btime[i];
                    }
                    btime[i]=0;
                }
            }
            sum=0;
            for(k=0;k<n;k++)
                sum=sum+btime[k];
        }
        while(sum!=0);
        for(i=0;i<n;i++)
        	total[i]=wtime[i]+avg[i];
        System.out.println("process\t\tBT\tWT\tTAT");
        for(i=0;i<n;i++)
        {
            System.out.println("process"+(i+1)+"\t"+avg[i]+"\t"+wtime[i]+"\t"+total[i]);
        }
        float avg_wt=0;
        float avg_tat=0;
        for(j=0;j<n;j++)
        {
            avg_wt+=wtime[j];
        }
        for(j=0;j<n;j++)
        {
            avg_tat+=total[j];
        }
        System.out.printf(" Average waiting time %.2f "
                + "\n Average turn around time %.2f",(avg_wt/n), (avg_tat/n));
    }
}
