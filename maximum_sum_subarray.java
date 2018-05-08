import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class rebuild{
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(buffer.readLine());
            String []arr = buffer.readLine().split(" ");
            int []number = new int[N];
            int i  = 0;
            for(String s:arr){
               number[i] = Integer.parseInt(s);
               i++;
            }
            int ans1 = Max_con_sum(number);
            Arrays.sort(number);
            int ans2 = number[number.length -1];
            int sum = number[number.length-1];
            for(int j = number.length -2;j>=0;j--){
                sum = Math.max(number[j],sum+number[j]);
                ans2 = Math.max(ans2,sum);
            }
            System.out.println(ans1+" "+ans2);
        }

    }
    public static int Max_con_sum(int []arr){
        int max_so_far = arr[0];
        int sum_max = arr[0];
        for(int i=1;i<arr.length;i++){
            sum_max = Math.max(arr[i],sum_max+arr[i]);
            max_so_far = Math.max(max_so_far,sum_max);
        }
        return max_so_far;
    }
}
