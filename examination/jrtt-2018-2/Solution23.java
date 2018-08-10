import java.util.Scanner;

/**
 * @author
 * @create 2018-08-10 13:23
 **/
public class Solution23 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int count = 0;
        for(int y = k+1;y<=n;y++){
            for(int m=0;(m*y+k)<=n;m++) {
                for (int i = m * y + k; i < (m + 1) * y; i++) {
                    if (i % y >= k) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
