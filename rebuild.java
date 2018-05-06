/***
    To find the max of each subarray in the array..
 ***/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class rebuild{
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(buffer.readLine());
        }
        minele(arr,3);
    }
    public static void minele(int arr[],int k){
        //Create the double ended queue...
        ArrayDeque<Integer> que = new ArrayDeque<Integer>(k);
        //process first k elements..
        int i;
        for(i=0;i<k;i++){
            //if element is lesser than incoming remove from the last..
            while(!(que.isEmpty()) && arr[i]>=arr[que.getLast()])
                que.removeLast();
            //add index to queue..
            que.add(i);
        }
        for(;i<arr.length;i++){
            //first element of the dequeue is maximum..
            System.out.println(arr[que.getFirst()]);
            //if any element is out of segment remove that
            while(!(que.isEmpty()) && que.getFirst() <= i-k)
                que.remove();
            //if element is lesser than the incoming element remove that...
            while(!(que.isEmpty())&&arr[i]>=arr[que.getLast()])
                que.removeLast();
            que.add(i);
        }
        //print max of last subarray...
        System.out.println(arr[que.getFirst()]);
        que.clear();

    }
}
