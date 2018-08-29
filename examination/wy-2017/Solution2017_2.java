import java.util.*;

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
        Integer[] a = {1,1,2,2,2,3,3,3,3,4,5,5,6,8,8};
        Integer r=Arrays.binarySearch(a,9);
        List<String> list= new ArrayList<>();
        System.out.println(r);
    }


}
