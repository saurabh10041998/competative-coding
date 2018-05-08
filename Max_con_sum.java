import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Kadane's Algorithm to  find the maximum contigious sum...
 */

public class rebuild{
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String []arr = buffer.readLine().split(" ");
        int number[] = new int[N+1];
        int i = 0;
        for(String s:arr){
             number[i] = Integer.parseInt(s);
             i++;
        }
        int max_con_sum = Max_con_sum(number);
        System.out.println("Maximum contigious sum of the array "+max_con_sum);
    }

    /**
     *
     * @param arr : Array from which contigious sum is obtained..
     * @return : Max contigious sum...
     */
    public static int Max_con_sum(int []arr){
        int Max_so_far = 0;
        int Max_ending_here = 0;
        for(int x:arr){
            Max_ending_here = Max_ending_here + x;
            if(Max_ending_here < 0)
                Max_ending_here = 0;
            if(Max_so_far < Max_ending_here)
                Max_so_far = Max_ending_here;
        }
        return Max_so_far;
    }
}