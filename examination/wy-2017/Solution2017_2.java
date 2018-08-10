import java.util.HashSet;
import java.util.Scanner;

/**
 * @author
 * @create 2018-08-10 18:41
 **/
public class Solution2017_2 {

    public int Cmn(int m,int n){
        int x=1,y=1;
        for(int i=n;i>n-m;i--){
            x*=i;
        }
        for(int i=1;i>=m;i++){
            y*=i;
        }
        return x/y;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int ball[] = new int[n];
        for(int i=0;i<n;i++){
            ball[i] = sc.nextInt();
        }
        int countNotOne=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
           if(ball[i] != 1){
               set.add(ball[i]);
           }
        }
        //for

    }
}
