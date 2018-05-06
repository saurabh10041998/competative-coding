/***
 * Generating permutation of the string(without repition)storing in the Arraylist...
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class rebuild{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<String>perm = new ArrayList<String>();
        perm = generate_permutation(line,0,line.length()-1,perm);
        for(String s:perm)
            System.out.println(s);
        System.out.println(perm.contains("ABCD"));
        System.out.println(perm.size());
    }

    /**
     *
     * @param a String on which permutation is applied..
     * @param l first character pointer of the string...
     * @param r rear character pointer of the string...
     * @param perm Arraylist containing the all permutation of the string...
     */
    public static ArrayList<String> generate_permutation(String a,int l,int r,ArrayList<String>perm){
        if(l == r)
        {
            perm.add(a);
            return perm;
        }
        else{
            for(int i=l;i<=r;i++){

                    a = swap(a, l, i);
                    perm = generate_permutation(a, l + 1, r, perm);
                    a = swap(a, l, i);

            }
        }
        return perm;
    }

    /**
     *
     * @param str = string on which swapping operarion is performed..
     * @param i   = i th  char to swap
     * @param j   = j char to swap.
     * @return
     */
    public static String swap(String str,int i,int j){
        char temp;
        char []A = str.toCharArray();
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return String.valueOf(A);
    }
}
